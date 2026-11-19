import ollama

# Texto que vamos a resumir
texto = """
La inteligencia artificial es una tecnología que permite a las máquinas
realizar tareas que normalmente requieren inteligencia humana.
Se utiliza en medicina, educación, transporte y programación.
Entre sus ventajas destacan la automatización de tareas y el análisis
rápido de grandes cantidades de datos.
Sin embargo, también presenta riesgos relacionados con la privacidad,
la seguridad y la sustitución de algunos puestos de trabajo.
"""

# 1. PROMPT POBRE
prompt_pobre = "Resume esto:\n" + texto

respuesta1 = ollama.chat(
    model='qwen3.5:4b',
    think=False,
    messages=[
        {'role': 'user', 'content': prompt_pobre}
    ]
)

resumen1 = respuesta1['message']['content']


# 2. PROMPT MEJORADO
# Incluye rol, tarea, límites y formato

prompt_mejorado = """
ROL:
Eres un profesor especializado en inteligencia artificial.

TAREA:
Resume el siguiente texto destacando las ideas principales.

LÍMITES:
- Utiliza un máximo de 40 palabras.
- No inventes información.
- Utiliza un lenguaje sencillo.

FORMATO:
- Escribe un único párrafo.
- No añadas títulos.

TEXTO:
""" + texto

respuesta2 = ollama.chat(
    model='qwen3.5:4b',
    think=False,
    messages=[
        {'role': 'user', 'content': prompt_mejorado}
    ]
)

resumen2 = respuesta2['message']['content']


# 3. CONTAR PALABRAS

palabras1 = len(resumen1.split())
palabras2 = len(resumen2.split())


# 4. COMPARAR RESULTADOS

print("========== PROMPT POBRE ==========")
print(resumen1)
print("Número de palabras:", palabras1)

print("\n========== PROMPT MEJORADO ==========")
print(resumen2)
print("Número de palabras:", palabras2)

print("\n========== COMPROBACIÓN ==========")

if palabras2 <= 40:
    print("El segundo resumen respeta el límite de palabras.")
else:
    print("El segundo resumen NO respeta el límite de palabras.")


# 5. GUARDAR TODO EN UN FICHERO

with open("comparacion_prompts.txt", "w", encoding="utf-8") as archivo:

    archivo.write("PROMPT POBRE:\n")
    archivo.write(prompt_pobre + "\n\n")

    archivo.write("RESPUESTA 1:\n")
    archivo.write(resumen1 + "\n")
    archivo.write(f"Palabras: {palabras1}\n\n")

    archivo.write("PROMPT MEJORADO:\n")
    archivo.write(prompt_mejorado + "\n\n")

    archivo.write("RESPUESTA 2:\n")
    archivo.write(resumen2 + "\n")
    archivo.write(f"Palabras: {palabras2}\n\n")

    archivo.write("COMPARACIÓN:\n")
    archivo.write(f"Prompt pobre: {palabras1} palabras\n")
    archivo.write(f"Prompt mejorado: {palabras2} palabras\n")

    archivo.write("\nLÍMITE DE 40 PALABRAS:\n")

    if palabras2 <= 40:
        archivo.write("Cumple el límite.\n")
    else:
        archivo.write("No cumple el límite.\n")

print("\nArchivo comparacion_prompts.txt creado correctamente.")