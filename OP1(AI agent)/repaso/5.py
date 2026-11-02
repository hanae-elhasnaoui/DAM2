import ollama
import time
import sys

sys.stdout.reconfigure(encoding="utf-8")

modelo = "qwen3.5:4b"

messages = [
    {"role": "system", "content": "Eres un asistente útil. Responde en español."}
]

tiempos = []

while True:
    pregunta = input("\nTú: ")

    if pregunta.lower().strip() == "salir":
        break

    messages.append({"role": "user", "content": pregunta})

    inicio = time.time()

    respuesta = ollama.chat(
        model=modelo,
        think=False,
        stream=True,
        messages=messages
    )

    texto = ""

    print("\nIA: ", end="", flush=True)

    for r in respuesta:
        contenido = r["message"].get("content", "")
        print(contenido, end="", flush=True)
        texto += contenido

    tiempo_total = time.time() - inicio

    messages.append({"role": "assistant", "content": texto})
    tiempos.append(tiempo_total)

    print(f"\nTiempo: {tiempo_total:.1f} segundos")


print("\n---------- RESUMEN ----------")

if len(tiempos) > 0:
    print(f"Turnos: {len(tiempos)}")
    print(f"Tiempo medio: {sum(tiempos) / len(tiempos):.1f} segundos")
    print(f"Turno más lento: {tiempos.index(max(tiempos)) + 1}")
    print(f"Tiempo del turno más lento: {max(tiempos):.1f} segundos")
else:
    print("No hubo turnos.")


# CONCLUSIÓN:
# ¿Los turnos se vuelven más lentos?
# Respuesta: ...
# ¿Por qué?
# Respuesta: ...