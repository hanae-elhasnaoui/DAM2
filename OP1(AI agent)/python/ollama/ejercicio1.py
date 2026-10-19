import ollama
response = ollama.chat(
    model='qwen3.5:4b',
    think=False,
    messages=[{'role': 'user',
               'content': '¿Cuánto es 2 + 8?'}])
print(response['message']['content'])
