import ollama
import time
import sys

sys.stdout.reconfigure(encoding="utf-8")


def consultar_modelo(modelo: str, pregunta: str, system: str):

    inicio = time.time()

    respuesta = ollama.chat(
        model=modelo,
        think=False,
        stream=True,
        messages=[
            {"role": "system", "content": system},
            {"role": "user", "content": pregunta}
        ]
    )

    texto = ""

    for r in respuesta:
        contenido = r["message"].get("content", "")
        texto += contenido

    final = time.time() - inicio

    # Mostrar la respuesta para comprobar si respeta el system
    print(f"\nModelo: {modelo}")
    print(f"System: {system}")
    print(f"Respuesta: {texto}\n")

    return modelo, system, final, len(texto)


pregunta = "Si 5 máquinas fabrican 5 piezas en 5 minutos, ¿cuánto tardan 100 máquinas en fabricar 100 piezas?"

modelos = ["llama3.2:1b", "qwen3.5:4b"]

systems = [
    "Responde en una sola frase.",
    "Explica la respuesta paso a paso."
]

resultado = []

# Ejecutar las 4 combinaciones
for modelo in modelos:
    for system in systems:
        fila = consultar_modelo(modelo, pregunta, system)
        resultado.append(fila)


# Mostrar tabla
print("\n---------------- TABLA DE RESULTADOS ----------------")

print(f"{'Modelo':<15} {'System':<35} {'Tiempo':<12} {'Caracteres':<12}")
print("-" * 80)

for fila in resultado:
    print(f"{fila[0]:<15} {fila[1]:<35} {fila[2]:<12.1f} {fila[3]:<12}")

# El modelo pequeño no respeta igual de bien las instrucciones del system.
# Cuando se le pide una sola frase, responde con varias frases y comete errores
# en el razonamiento. En cambio, el modelo grande responde con una sola frase
# cuando se le pide y explica paso a paso cuando corresponde.