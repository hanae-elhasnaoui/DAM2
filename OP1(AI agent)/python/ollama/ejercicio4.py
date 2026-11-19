
import ollama
import json

preguntas = [
    "Resume qué es la inteligencia artificial.",
    "Resume las ventajas de utilizar Python.",
    "Resume qué es una base de datos."
]

validos = 0

for pregunta in preguntas:

    prompt = f"""
    Resume el siguiente tema: {pregunta}

    Responde únicamente en formato JSON con estos campos:
    - "puntos": una lista de ideas principales.
    - "palabras": un número entero con la cantidad de palabras del resumen.

    No escribas nada fuera del JSON.

    Ejemplo:
    {{
        "puntos": ["Primera idea", "Segunda idea"],
        "palabras": 5
    }}
    """

    response = ollama.chat(
        model='qwen3.5:4b',
        think=False,
        messages=[
            {'role': 'user', 'content': prompt}
        ]
    )

    respuesta = response['message']['content']

    print("\nPREGUNTA:", pregunta)
    print("RESPUESTA:", respuesta)

    try:
        datos = json.loads(respuesta)

        if (
            isinstance(datos, dict)
            and isinstance(datos.get("puntos"), list)
            and all(isinstance(p, str) for p in datos["puntos"])
            and type(datos.get("palabras")) is int
        ):
            validos += 1
            print("JSON válido")
        else:
            print("JSON con estructura incorrecta")

    except json.JSONDecodeError:
        print("Error: la respuesta no es un JSON válido")


print("\nRESULTADO FINAL")
print("Preguntas realizadas:", len(preguntas))
print("JSON válidos:", validos)