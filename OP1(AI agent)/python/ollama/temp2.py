import ollama

prompt_sistema = """Eres un asistente que clasifica opiniones.
Tu tarea es clasificar el comentario en: Positivo, Negativo o Neutro.
Reglas: No expliques nada, responde con una sola palabra exacta.
Formato: Una palabra.

Ejemplos:
Comentario: "Me encanta este producto, es genial."
Respuesta: Positivo

Comentario: "Llegó roto y funciona muy mal."
Respuesta: Negativo"""

comentarios = [
    ("El servicio fue excelente y muy rápido.", "Positivo"),
    ("No me gustó nada, tiré mi dinero.", "Negativo"),
    ("El paquete llegó hoy a las cinco.", "Neutro"),
    ("La mejor compra que he hecho este año.", "Positivo"),
    ("Pésima calidad, se rompió al primer día.", "Negativo"),
    ("La caja es de cartón y mide 20 cm.", "Neutro"),
    ("Muy amables y atentos en todo momento.", "Positivo"),
    ("Llevo un mes esperando y nadie responde.", "Negativo"),
    ("El pedido contiene tres unidades.", "Neutro"),
    ("Todo perfecto, volveré a comprar seguro.", "Positivo")
]

def probar_temperatura(valor_temp: float, texto: str):
    response = ollama.chat(
        model="qwen3.5:4b",
        think=False,
        messages=[
            {"role": "system", "content": prompt_sistema},
            {"role": "user", "content": f'Comentario: "{texto}"\nRespuesta:'}
        ],
        options={"temperature": valor_temp}
    )
    return response["message"]["content"].strip()

temperaturas = [0, 0.8]

for t in temperaturas:
    print(f"\n=== Temperatura: {t} ===")
    aciertos = 0
    respuestas_lista = []
    
    for txt, cor in comentarios:
        r = probar_temperatura(t, txt)
        respuestas_lista.append(r)
        print(f"IA: {r} | Correcto: {cor}")
        
        if r.lower() == cor.lower():
            aciertos += 1
            
    print(f"--> Aciertos: {aciertos}/10")
    print(f"--> Positivo: {respuestas_lista.count('Positivo')} | Negativo: {respuestas_lista.count('Negativo')} | Neutro: {respuestas_lista.count('Neutro')}")
