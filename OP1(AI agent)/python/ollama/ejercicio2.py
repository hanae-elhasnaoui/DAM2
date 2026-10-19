import ollama
pregunta=input("cual es su pregunta ?")

print("*******************con qwen3.5:4b*************************************")

response4b = ollama.chat(
    model='qwen3.5:4b',
    think=False,
    messages=[  {'role' : 'systeme',
                 'content':" respuestas de menos de 50 palabras"
                 },
                {'role': 'user',
               'content': pregunta}])
print(response4b['message']['content'])
print(f"{response4b['message']['content']}")

print("*******************con qwen3.5:0.8b*************************************")
try:
    response8b = ollama.chat(
        model='qwen3.5:0.8b',
        think=False,
        messages=[
            {'role' : 'systeme',
                 'content':" respuestas de menos de 50 palabras"
                 },
            {'role': 'user', 'content': pregunta}]
    )
    print(response8b['message']['content'])
except Exception as e:
    print(f"Error con el modelo 0.8b: {e}")