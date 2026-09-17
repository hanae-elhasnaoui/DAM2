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


"""
lista=[1,2,3]

lista.append(4)

for n in lista :
    print(n)

