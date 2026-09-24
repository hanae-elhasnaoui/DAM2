"""
import math
print("Hola Python")

x =5
if x<8:
    print("psitivo")


a=3+7
print(a)


# este programa imprime mo nombre
# conebtario de ejemplo
nombre = "hanae"
print (nombre)



edad = input("edad:")
edad = int(edad)
print(f"hola {nombre} , ek año que viene tendras {edad+1}")


v=10
print(type(v))
v="han"
print(type(v))

v=[1,2,3]
print(type(v))



n=int(input("introduce un numero :"))
print(n)
n=float(n)
print(n)


nombre= input("introduce tu nombre : ")
edad=input("introduce tu edad : ")

print(f"hola {nombre} tienes {edad} años")



n=5
c=n**2
cubo=n**3
raiz=math.sqrt(n)
print(c,cubo,raiz)




num= int(input("introduce  un numero : "))
if num>0:
    print("positivo")
elif num==0:
    print("cero")
else:
    print("negativo")


n = int(input("Número: "))
if n <10:
    print("pequiño")
elif n <100:
    print("medio")
else:
    print("grande")


   
n = int(input("Número: "))
print("par" if n%2==0 else "impar")

 

palabra=input("introduce un palabra :")

print("correcto" if palabra.lower()=="python" else "no es la correcta palabra")




nombres =["ana","luis"," hajar"]

for n in nombres:
    print(n)

for i in range(1,11):
    print(i)



suma = 0
n=int(input("introduce un numero : "))
while n!=0:
    suma += n
    n=int(input("introduce un numero si quires parar escribe 0 :"))

print(f"suma: {suma}")



for n in range(1 , 21):
    if(n%3 != 0):
        print(n)


for n in range(1 , 21):
   if  n%7 == 0:
      break
   print(n)




def saludar(nombre):
    print(f"hola  {nombre}")

saludar("hanae")


def sumar (a,b) :
    return a + b

print(sumar(2,1))




def saludo(nombre="invitado"):
    print(f"Hola {nombre}")

saludo()
saludo("hana")



def analizar(lista):
    return  sum(lista),max(lista) , min (lista)
lis =[1,8,9,4]
suma , mayor , menor = analizar(lis)

print(f" suma : {suma} mayor :{mayor} menor :{menor}")



lista=[1,2,3]

lista.append(4)

print(lista)

# opcion 1
for n in lista :
    print(n)

# opcion 2
print(*lista , sep=" ")

# opcion 3
print(lista[0])
print(lista[1])
print(lista[2])



alumno= {

    "nombre" : "ANA",
    "edad" : "17",
    "curso":"2º"
}

print(alumno)


for clave, valor in alumno.items():
    print(clave ,":",  valor)


for valor in alumno.values():
    print(valor)

print("*******************")
print(*alumno.items() ,sep="\n")

for clave , valor in alumno.items():
    print(f"{clave.capitalize} : {valor}")


s={1,2,2,1,3,3}
print(s)
colores={"rojo","azul","rojo"}
colores.add("marillo")
print(colores)

futbol = {"Ana", "Luis", "Marta", "Sofía"}
baloncesto = {"Marta", "Carlos", "Ana"}

print("los que practica ambos deportes : " ,futbol & baloncesto)
print("los que oractican solo futbol : " ,futbol -baloncesto)
print("los que oractican al menos uno de los dos : " ,futbol |baloncesto)


lunes = {"Ana", "Luis", "Marta", "Sofía"}
martes = {"Marta", "Carlos", "Ana", "Julia"}

print("Solo un dia : " , lunes ^ martes)
print("Total alumnos asistieron : " , lunes|martes)
print("julia vino el lunes " if  "julia" in martes else  " julia no viene in martes")



nums = [1, 2, 3, 4]
cuadrados=[n*n for n in nums]

print(*cuadrados)

for c in cuadrados:
    print(c ,end=", ")



import random

# A diferencia de range(), randint(1, 10) sí incluye el 10.

print(random.randint(1, 10))

from math import pi, sin

print(pi, sin(pi/2))


try:
    n = int(input("Número: "))
    print("Has introducido:", n)
except ValueError:
    print("Eso no es un número válido.")

try:
    a = int(input("A: "))
    b = int(input("B: "))
    print(a / b)
except ZeroDivisionError:
    print("No se puede dividir entre cero.")
except ValueError:
    print("Entrada no válida.")


try:
    x = int(input("Número: "))
    print(10 / x)
except Exception:
    print("Error.")
finally:
    print("Fin del programa.")
#Pide un número entero y repite hasta que el usuario introduzca uno válido.

while(True):
    try:
        n=int(input("Introduce un numero :"))
        break
    except ValueError:
        print("Introduzca un numero entero ")


nums=[]
while(True):
    try:
        n=input("Introduce un numero :") 
        if n=="fin":
            break
        else:
            n=float(n)
            nums.append(n)
    except ValueError:
        print("Introduzca un numero ")


print("la media :" , sum(nums)/len(nums))
print("Maximo :", max(nums))
print("Minimo : ",min(nums))


        """

dic={}
while True:
        nombre =input("introduce un nombre : ")
        if nombre=="fin":
            break
        else:
            edad=int(input("intoduce su edad :"))
            dic[nombre]=edad
print(dic)