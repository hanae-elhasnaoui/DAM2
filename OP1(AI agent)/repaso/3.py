import ollama
import time
import sys

sys.stdout.reconfigure(encoding="utf-8")


def consultar_modelo(modelo: str, pregunta: str):

    inicio = time.time()

    respuesta = ollama.chat(
        model=modelo,
        think=False,
        stream=True,
        messages=[
            {"role": "system", "content": "Responde de forma clara y detallada."},
            {"role": "user", "content": pregunta}
        ]
    )

    primer_token = None

    for r in respuesta:

        contenido = r["message"].get("content", "")

        # Medir solo cuando aparece el primer texto real
        if contenido and primer_token is None:
            primer_token = time.time() - inicio

        # Mostrar la respuesta poco a poco
        print(contenido, end="", flush=True)

    tiempo_total = time.time() - inicio

    print(f"\n\nTiempo primera palabra: {primer_token:.1f} segundos")
    print(f"Tiempo total: {tiempo_total:.1f} segundos")

    return primer_token, tiempo_total


pregunta = "Explica qué es la inteligencia artificial y cómo funciona, con ejemplos."

modelos = ["llama3.2:1b", "qwen3.5:4b"]

resultados = []

for modelo in modelos:

    print(f"\n-------------- {modelo} --------------")

    primer_token, tiempo_total = consultar_modelo(modelo, pregunta)

    resultados.append((modelo, primer_token, tiempo_total))


# Comparación final
print("\n-------------- COMPARACIÓN --------------")

for modelo, primer_token, tiempo_total in resultados:
    print(
        f"{modelo}: "
        f"Primera palabra = {primer_token:.1f}s | "
        f"Tiempo total = {tiempo_total:.1f}s"
    )

# RESULTADOS:
# llama3.2:1b -> primera palabra = 1.1 s, tiempo total = 8.3 s
# qwen3.5:4b  -> primera palabra = 2.3 s, tiempo total = 62.0 s

# CONCLUSIÓN:
# El modelo llama3.2:1b se nota más rápido porque muestra la primera palabra en 1.1 s, frente a los 2.3 s de qwen3.5:4b.
# Sí, coincide con el que termina antes: llama3.2:1b tarda 8.3 s en total, mientras que qwen3.5:4b tarda 62.0 s.
