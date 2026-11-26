import ollama

temperaturas = [0, 0.3, 0.8, 1.2]

def probar_temperatura(valor_temp: float):
    mensajes = [
        {"role": "user", "content": "Escribe un eslogan corto para una cafetería en una sola frase."}
    ]
    
    response = ollama.chat(
        model="qwen3.5:4b",
        think=False,
        messages=mensajes,
        options={
            "temperature": valor_temp
        }
    )
    
    return response["message"]["content"].strip()

for t in temperaturas:
    print(f"********** {t} ************")
    respuestas_t = []
    for i in range(5):
        r = probar_temperatura(t)
        respuestas_t.append(r)
        print(r)
    
    print(f"--> Respuestas distintas: {len(set(respuestas_t))} de 5\n")
