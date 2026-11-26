#set page(paper: "a4", margin: (x: 2cm, y: 1.8cm))
#set text(font: "DejaVu Sans", size: 10pt, lang: "es")
#set par(justify: true, leading: 0.65em)
#set heading(numbering: "1.")
#show heading.where(level: 1): set text(fill: rgb("07345a"), size: 14pt, weight: "bold")
#show heading.where(level: 2): set text(fill: rgb("087cff"), size: 11pt, weight: "bold")
#let cmd(x) = block(fill: rgb("f2f5f9"), inset: 10pt, radius: 4pt, width: 100%)[#text(font: "DejaVu Sans Mono", size: 9pt)[#x]]
#let foto(x) = block(stroke: (paint: rgb("a4b8ce"), thickness: 0.7pt), inset: 10pt, width: 100%, height: 44pt)[#text(fill: rgb("65788a"), size: 9pt)[CAPTURA PENDIENTE: #x]]

#align(center)[
  #text(size: 19pt, weight: "bold", fill: rgb("07345a"))[INFORME DE PRÁCTICA — COMANDOS LINUX]
  #v(6pt)
  #text(size: 13pt)[ Ejercicio 1]
  #v(8pt)
  #text()[Alumna: Hanae El Hasnaoui]
]

*Objetivo.* En esta práctica voy a crear una estructura de carpetas y archivos, escribir y consultar su contenido, modificar permisos, copiar y mover elementos y trabajar con archivos comprimidos. Documentaré cada paso con capturas de mi terminal.

*Antes de empezar.* En el enunciado hay rutas que no coinciden con el árbol inicial: aparecen `/home/alumno/n1`, `/home/alumno/d3`, `/home/d4`, `/home/n1/d1/d2/f2` y `/home/n1/d3`. Además, el apartado 7 pide vaciar `n1`, aunque los apartados 9 y 10 vuelven a necesitar sus archivos. Para que la práctica sea reproducible, usaré la estructura del dibujo, que parte de `/home/alumno/n1`, y crearé una copia de seguridad antes del borrado. En cada apartado señalaré cuándo estoy adaptando una ruta del enunciado. Las capturas deberán ser de mis propias pruebas.

= Crear el árbol de directorios y archivos como usuario alumno

== Crear el usuario

#cmd(`sudo adduser alumno`)

Este comando crea el usuario, solicita su contraseña y normalmente prepara su directorio personal `/home/alumno`. Otra posibilidad es utilizar `sudo useradd -m alumno`, seguido de `sudo passwd alumno`; `useradd` es una herramienta de nivel más bajo y requiere indicar algunas opciones explícitamente.
#image("assets/image.png")

Entro con la cuenta del alumno:
#cmd(`su - alumno`)

Compruebo mi identidad y ubicación:
#cmd(`whoami
pwd`)

#image("assets/image-2.png")
== Crear las carpetas y los archivos

El dibujo del enunciado indica la siguiente estructura:
#cmd(`/home/alumno/
└── n1/
    ├── d1/
    │   ├── f1
    │   └── d2/
    │       └── f2
    └── d3/
        ├── f3
        └── f4`)

Creo las carpetas con `mkdir -p`. La opción `-p` permite crear también los directorios intermedios:
#cmd(`cd /home/alumno
mkdir -p n1/d1/d2 n1/d3`)

Creo los cuatro archivos vacíos con `touch`:
#cmd(`touch n1/d1/f1 n1/d1/d2/f2 n1/d3/f3 n1/d3/f4`)

Verifico la estructura:
#cmd(`ls -R /home/alumno/n1`)

Si tengo instalado `tree`, también puedo usar:
#cmd(`tree /home/alumno/n1`)

*Explicación.* `cd` cambia de directorio, `mkdir` crea carpetas, `touch` crea archivos vacíos y `ls -R` lista recursivamente el contenido. La ruta absoluta empieza por `/`; la relativa depende del directorio en el que me encuentro.
#image("assets/image-3.png")

= Escribir al menos tres líneas en f1, f2, f3 y f4 y ver su contenido

= 2. Escribir y visualizar el contenido de los archivos

== Escritura de los archivos

Primero, he utilizado el comando `echo` para escribir tres líneas de texto en cada uno de los archivos `f1`, `f2`, `f3` y `f4`.

He utilizado `>` para escribir la primera línea y `>>` para añadir las siguientes sin borrar el contenido anterior.

*Archivo f1:*

```bash
echo "Primera linea de f1" > /home/alumno/n1/d1/f1
echo "Segunda linea de f1" >> /home/alumno/n1/d1/f1
echo "Tercera linea de f1" >> /home/alumno/n1/d1/f1
```
#image("assets/image-4.png")
*Archivo f2:*

```bash
echo "Primera linea de f2" > /home/alumno/n1/d1/d2/f2
echo "Segunda linea de f2" >> /home/alumno/n1/d1/d2/f2
echo "Tercera linea de f2" >> /home/alumno/n1/d1/d2/f2
```

*Archivo f3:*

```bash
echo "Primera linea de f3" > /home/alumno/n1/d3/f3
echo "Segunda linea de f3" >> /home/alumno/n1/d3/f3
echo "Tercera linea de f3" >> /home/alumno/n1/d3/f3
```

*Archivo f4:*

```bash
echo "Primera linea de f4" > /home/alumno/n1/d3/f4
echo "Segunda linea de f4" >> /home/alumno/n1/d3/f4
echo "Tercera linea de f4" >> /home/alumno/n1/d3/f4
```

#block(
  fill: rgb("#F2F2F2"),
  inset: 15pt,
  width: 100%,
)[
  *CAPTURA 1:* Escritura de los archivos.
]

== Visualización del contenido

Después, he utilizado tres comandos diferentes para visualizar el contenido de los archivos.

=== Comando cat

```bash
cat /home/alumno/n1/d1/f1
```

El comando `cat` muestra todo el contenido del archivo directamente en la terminal.

=== Comando more

```bash
more /home/alumno/n1/d1/d2/f2
```

El comando `more` permite visualizar el contenido página por página.

=== Comando less

```bash
less /home/alumno/n1/d3/f3
```

El comando `less` permite visualizar el contenido y desplazarse hacia arriba y hacia abajo utilizando las flechas del teclado.

Para comprobar el contenido de `f4`, he utilizado:

```bash
cat /home/alumno/n1/d3/f4
```

#block(
  fill: rgb("#F2F2F2"),
  inset: 15pt,
  width: 100%,
)[
  *CAPTURA 2:* Visualización del contenido con cat, more y less.
]

== Diferencias entre los tres comandos

- *cat:* muestra todo el contenido del archivo de una vez.
- *more:* permite visualizar el contenido página por página.
- *less:* permite desplazarse hacia delante y hacia atrás y buscar palabras dentro del archivo.

Como los archivos contienen solamente tres líneas, la diferencia entre los comandos no se aprecia mucho. Sin embargo, cuando los archivos son más largos, `more` y `less` permiten leer su contenido de forma más cómoda.

= Cambiar los permisos de /home/alumno/n1 a rwx------

Muestro los permisos antes del cambio:
#cmd(`ls -ld /home/alumno/n1`)

Aplico los permisos solicitados:
#cmd(`chmod 700 /home/alumno/n1`)

Los compruebo:
#cmd(`ls -ld /home/alumno/n1`)

*Explicación.* El propietario tiene lectura (`r=4`), escritura (`w=2`) y ejecución (`x=1`), por tanto `4+2+1=7`. El grupo y otros usuarios no tienen ningún permiso: `0` y `0`. El resultado es `drwx------`. En una carpeta, `x` permite atravesarla y acceder a sus rutas internas; sin ese permiso, otros usuarios no pueden recorrer `n1` aunque conozcan los nombres de sus archivos.
#foto([Permisos antes y después de `chmod 700`.])

= Cambiar los permisos por defecto utilizando la máscara 333

Consulto la máscara actual:
#cmd(`umask`)

Cambio la máscara en esta sesión de terminal:
#cmd(`umask 333
umask`)

Creo elementos de prueba *fuera de n1* para observar el efecto sin alterar los archivos originales:
#cmd(`touch /home/alumno/prueba_umask.txt
mkdir /home/alumno/prueba_umask_dir
ls -ld /home/alumno/prueba_umask.txt /home/alumno/prueba_umask_dir`)

*Explicación.* La máscara `333` elimina bits de permisos de las nuevas creaciones. Los archivos normales parten habitualmente de `666` y los directorios de `777`; el cálculo real es una operación de bits, no una resta decimal. Con `umask 333`, un archivo nuevo suele quedar en `444` (`r--r--r--`) y un directorio en `444` (`r--r--r--`), sin permiso de ejecución para atravesarlo. Esta máscara dificulta mucho trabajar con carpetas nuevas.

*Para continuar la práctica*, restablezco la máscara habitual de mi sesión:
#cmd(`umask 022`)

No estoy anulando el resultado de la prueba: primero lo documento con una captura y después restablezco un valor práctico para los siguientes apartados.
#foto([Valor `333` y permisos de los elementos de prueba.])

= Crear un nuevo directorio d4 dentro de /home/alumno/n1

Después de restaurar `umask 022`, creo la carpeta:
#cmd(`mkdir /home/alumno/n1/d4
ls -ld /home/alumno/n1 /home/alumno/n1/d4`)

*Explicación.* Puedo crear `d4` porque estoy trabajando como propietario de `n1`, que conserva los permisos `rwx------` del apartado 3. Otros usuarios no podrían entrar en `n1` ni crear allí carpetas. Si mantuviera `umask 333`, la nueva carpeta tendría permisos muy restrictivos, por eso documenté la máscara y la restauré antes de continuar.
#foto([Creación de `d4` y comprobación con `ls -ld`.])

= Copiar el directorio d3 y su contenido dentro de d4

*Incoherencia del enunciado:* en este punto aparece `/home/alumno/d3`, pero en el árbol inicial `d3` está dentro de `/home/alumno/n1`. Utilizo la ubicación del dibujo:
#cmd(`cp -r /home/alumno/n1/d3 /home/alumno/n1/d4/
ls -R /home/alumno/n1/d4`)

*Explicación.* `cp -r` copia directorios de forma recursiva, incluidos sus archivos. Después de la copia, dentro de `d4` debe existir otra carpeta `d3` con `f3` y `f4`. Los permisos del apartado 3 afectan al acceso de otros usuarios, pero yo, como propietaria de `n1`, puedo realizar la copia.
#foto([Contenido de `d4/d3` después de `cp -r`.])

= Eliminar todo el contenido de n1, pero no el directorio n1

Este apartado entra en conflicto con los ejercicios posteriores, que necesitan los archivos de `n1`. Antes de borrar, creo una copia de seguridad fuera de `n1`:
#cmd(`cp -a /home/alumno/n1 /home/alumno/n1_respaldo`)

Compruebo la copia y después elimino *solo el contenido* de `n1`:
#cmd(`ls -R /home/alumno/n1_respaldo
find /home/alumno/n1 -mindepth 1 -maxdepth 1 -exec rm -rf -- {} +`)

Verifico que la carpeta `n1` sigue existiendo y está vacía:
#cmd(`ls -ld /home/alumno/n1
ls -la /home/alumno/n1`)

*Precaución.* `rm -rf` elimina sin pedir confirmación; reviso la ruta exacta antes de ejecutarlo. `find ... -mindepth 1` evita seleccionar el propio directorio `n1` y elimina también los elementos ocultos que haya dentro.

Para poder resolver después los puntos 9 y 10, restauro la copia *una vez documentado el borrado*:
#cmd(`cp -a /home/alumno/n1_respaldo/. /home/alumno/n1/
ls -R /home/alumno/n1`)

*Explicación.* He mostrado primero el resultado exigido —`n1` vacía— y luego he recuperado los datos de trabajo para continuar. Esta restauración es una decisión práctica necesaria por el orden contradictorio de los apartados.
#foto([`n1` vacía después del borrado y restauración posterior.])

= Cambiar los permisos de d4 y su contenido a rwxr-xr-x

*Incoherencia del enunciado:* aquí se pide `/home/d4`, pero `d4` se creó en `/home/alumno/n1/d4` en el apartado 5. Trabajo con esa ruta:
#cmd(`chmod -R 755 /home/alumno/n1/d4
ls -ld /home/alumno/n1/d4
ls -lR /home/alumno/n1/d4`)

*Explicación.* `755` significa `rwxr-xr-x`: el propietario puede leer, escribir y ejecutar; el grupo y los demás pueden leer y ejecutar. La opción `-R` aplica el cambio a todo el contenido, incluso a los archivos. Aunque el enunciado lo solicita, dar `x` a archivos de texto no es necesario en un uso normal; aquí lo hago porque se pide expresamente modificar también el contenido.

*Importante.* Aunque `d4` tenga permisos `755`, los demás usuarios seguirán sin poder llegar hasta ella mientras la carpeta padre `n1` mantenga `700`.
#foto([Resultado de `chmod -R 755` y `ls -lR`.])

= Intentar mover f2 a d4

*Incoherencia del enunciado:* indica `/home/n1/d1/d2/f2`, pero la ruta del árbol es `/home/alumno/n1/d1/d2/f2`. Como restauré el respaldo tras el punto 7, puedo probar:
#cmd(`mv /home/alumno/n1/d1/d2/f2 /home/alumno/n1/d4/
ls -l /home/alumno/n1/d4/f2`)

*Explicación.* `mv` mueve el archivo sin crear una copia adicional. En este caso el traslado debería funcionar para el usuario propietario, siempre que el archivo exista y las carpetas de origen y destino permitan la operación. Si no hubiera restaurado `n1` tras el apartado 7, el comando fallaría porque `f2` ya no existiría. No debo presentar ese error como un problema de permisos si la causa real es que se borró el archivo.
#foto([Movimiento de `f2` y comprobación de su nueva ubicación.])

= Copiar los archivos de d3 a n1 y comprimirlos como ejercicio.tar.gz

*Incoherencia del enunciado:* aparece `/home/n1/d3`; utilizo `/home/alumno/n1/d3` según el árbol inicial.

Copio los archivos de `d3` al directorio `n1`:
#cmd(`cp /home/alumno/n1/d3/f3 /home/alumno/n1/
cp /home/alumno/n1/d3/f4 /home/alumno/n1/
ls -l /home/alumno/n1/f3 /home/alumno/n1/f4`)

Creo el archivo comprimido desde el directorio `n1`:
#cmd(`cd /home/alumno/n1
tar -czvf ejercicio.tar.gz f3 f4`)

Compruebo qué contiene:
#cmd(`tar -tzvf /home/alumno/n1/ejercicio.tar.gz`)

*Explicación.* `tar` agrupa archivos; `-c` crea el paquete, `-z` aplica compresión gzip, `-v` muestra los nombres procesados y `-f` indica el nombre del archivo de salida. La opción `-t` permite listar el contenido del `.tar.gz` sin descomprimirlo.
#foto([Copia de `f3` y `f4`, creación del comprimido y listado con `tar -tzvf`.])

= Llevar el comprimido a d4 y renombrarlo comprimido_n2.tar.gz

Muevo y cambio el nombre en un solo comando:
#cmd(`mv /home/alumno/n1/ejercicio.tar.gz /home/alumno/n1/d4/comprimido_n2.tar.gz
ls -l /home/alumno/n1/d4/comprimido_n2.tar.gz`)

*Explicación.* `mv` sirve tanto para mover como para renombrar archivos. El contenido del comprimido no cambia; solo cambia su ubicación y su nombre.
#foto([Archivo `comprimido_n2.tar.gz` dentro de `d4`.])

= Descomprimir los archivos en el directorio d5

El enunciado menciona `d5`, pero no lo crea en ningún paso anterior. Creo esa carpeta dentro de `n1`:
#cmd(`mkdir -p /home/alumno/n1/d5`)

Extraigo el comprimido en `d5`:
#cmd(`tar -xzvf /home/alumno/n1/d4/comprimido_n2.tar.gz -C /home/alumno/n1/d5`)

Compruebo los archivos extraídos y su contenido:
#cmd(`ls -l /home/alumno/n1/d5
cat /home/alumno/n1/d5/f3
cat /home/alumno/n1/d5/f4`)

*Explicación.* `-x` extrae, `-z` indica que el archivo está comprimido con gzip, `-v` muestra los nombres y `-f` identifica el archivo. La opción `-C` indica en qué directorio se extrae el contenido.
#foto([Extracción en `d5` y comprobación de `f3` y `f4`.])

= Conclusión

En esta práctica he trabajado con rutas absolutas y relativas, creación de usuarios, directorios y archivos, lectura de contenidos, permisos (`chmod` y `umask`), copia (`cp`), movimiento (`mv`), borrado (`find` y `rm`) y compresión (`tar`). También he comprobado que los permisos de una carpeta padre pueden impedir el acceso a las carpetas hijas, aunque estas últimas tengan permisos más amplios.

*Revisión antes de entregar:* sustituir todas las cajas «CAPTURA PENDIENTE» por imágenes de mi terminal; completar las observaciones con los resultados reales; comprobar con el profesor las rutas contradictorias del enunciado si exige respetarlas literalmente.
