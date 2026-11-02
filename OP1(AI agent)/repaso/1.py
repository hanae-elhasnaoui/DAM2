
import ollama
import time
import sys

sys.stdout.reconfigure(encoding="utf-8")


def consultar_modelo(modelo:str,pregunta:str,think:bool):  
    inicio = time.time()

    respuesta = ollama.chat(
        model=modelo,
        think=think,
        stream=True,
        messages=[
            {"role": "system", 
            "content": ""
             },
            {
                "role": "user",
                "content": pregunta
            }
        ]
    )

    primer_token = None

    for r in respuesta:
        if primer_token is None:
            primer_token = time.time() - inicio

        print(r["message"]["content"], end="", flush=True)

    final = time.time() - inicio
    
    return final

print("--------------sin thinking --------------")
timposin=consultar_modelo("qwen3.5:4b","Si 5 máquinas fabrican 5 piezas en 5 minutos, ¿cuánto tardan 100 máquinas en fabricar 100 piezas?",False)
print("\n--------------con thinking --------------")
timpocon=consultar_modelo("qwen3.5:4b","Si 5 máquinas fabrican 5 piezas en 5 minutos, ¿cuánto tardan 100 máquinas en fabricar 100 piezas?",True)


print(f"\nTiempo sin thinking: {timposin:.1f} segundos")
print(f"Tiempo con thinking: {timpocon:.1f} segundos")


if timposin > timpocon:
    veces = timposin / timpocon
    print(f"Sin thinking es {veces:.1f} veces más lento que con thinking")

elif timpocon > timposin:
    veces = timpocon / timposin
    print(f"Con thinking es {veces:.1f} veces más lento que sin thinking")

else:
    print("Los dos tardaron lo mismo")
    
# Resultados: sin thinking = 1.1s; con thinking = 44.3s.
