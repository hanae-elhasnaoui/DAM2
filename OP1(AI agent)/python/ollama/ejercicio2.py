import ollama

pregunta = input("¿Cuál es su pregunta?: ")

print("\n******************* con qwen3.5:4b *************************************")
try:
    response4b = ollama.chat(
        model='qwen3.5:4b',  # Corregido: '4hb' cambiado a '4b'
        messages=[
            # Corregido: 'systeme' cambiado a 'system'
            {'role': 'system', 'content': "Respuestas de menos de 50 palabras."},
            {'role': 'user', 'content': pregunta}
        ]
    )
    print(response4b['message']['content'])
except Exception as e:
    print(f"Error con el modelo 4b: {e}")


print("\n******************* con qwen3.5:0.8b *************************************")
try:
    response8b = ollama.chat(
        model='qwen3.5:0.8b',
        messages=[
            # Corregido: 'systeme' cambiado a 'system'
            {'role': 'system', 'content': "Respuestas de menos de 50 palabras."},
            {'role': 'user', 'content': pregunta}
        ]
    )
    print(response8b['message']['content'])
except Exception as e:
    print(f"Error con el modelo 0.8b: {e}")
