package es.elorrieta.gymapp.bd

import es.elorrieta.gymapp.bd.entidades.Ejercicio
import es.elorrieta.gymapp.bd.entidades.Usuario
import es.elorrieta.gymapp.bd.entidades.Workout

// Precarga de datos de prueba (UD4.2): si las tablas están vacías, se rellenan.
// Así los 4 miembros del grupo tienen los mismos datos al ejecutar la App.
// IMPORTANTE: llamar siempre dentro de una corrutina con Dispatchers.IO
// Datos: 4 usuarios (2 entrenadores y 2 clientes), 9 workouts (3 por nivel) y 36 ejercicios
object DatosIniciales {

    @Synchronized
    fun cargarSiVacia(db: GymDatabase) {

        // ---------- USUARIOS ----------
        val usuarioDao = db.getUsuarioDao()
        if (usuarioDao.getAll().isEmpty()) {
            usuarioDao.insertAll(
                Usuario(
                    login = "entrenador", pass = "1234",
                    nombre = "Ane", apellidos = "Etxeberria Ruiz",
                    email = "ane@correo.com", fechaNacimiento = "10/05/1990",
                    tipo = "entrenador"
                ),
                Usuario(
                    login = "entrenador2", pass = "1234",
                    nombre = "Iker", apellidos = "Zubiri Lasa",
                    email = "iker@correo.com", fechaNacimiento = "22/11/1985",
                    tipo = "entrenador"
                ),
                Usuario(
                    login = "cliente", pass = "1234",
                    nombre = "Jon", apellidos = "Pérez Gil",
                    email = "jon@correo.com", fechaNacimiento = "14/03/1999",
                    tipo = "cliente"
                ),
                Usuario(
                    login = "cliente2", pass = "1234",
                    nombre = "Maite", apellidos = "Gómez Arana",
                    email = "maite@correo.com", fechaNacimiento = "03/07/2001",
                    tipo = "cliente"
                )
            )
        }

        // ---------- WORKOUTS Y EJERCICIOS ----------
        val workoutDao = db.getWorkoutDao()
        val ejercicioDao = db.getEjercicioDao()
        if (workoutDao.getAll().isEmpty()) {

            // ===== NIVEL 1 =====

            // insert() devuelve el id del workout: lo usamos para sus ejercicios
            val w1 = workoutDao.insert(
                Workout(
                    nombre = "Iniciación cuerpo completo", nivel = 1,
                    video = "https://www.youtube.com/results?search_query=rutina+cuerpo+completo+principiantes"
                )
            )
            ejercicioDao.insertAll(
                Ejercicio(workoutId = w1, orden = 1, nombre = "Sentadillas", tipo = "Piernas",
                    descripcion = "Baja la cadera como si te sentaras y sube despacio.", tiempoEstimado = 5),
                Ejercicio(workoutId = w1, orden = 2, nombre = "Flexiones en rodillas", tipo = "Pecho",
                    descripcion = "Apoya las rodillas y baja el pecho hasta casi tocar el suelo.", tiempoEstimado = 5),
                Ejercicio(workoutId = w1, orden = 3, nombre = "Plancha", tipo = "Core",
                    descripcion = "Mantén el cuerpo recto sobre antebrazos y puntas de los pies.", tiempoEstimado = 3)
            )

            // Workout SIN vídeo (el vídeo no es obligatorio)
            val w2 = workoutDao.insert(Workout(nombre = "Cardio suave", nivel = 1))
            ejercicioDao.insertAll(
                Ejercicio(workoutId = w2, orden = 1, nombre = "Marcha en el sitio", tipo = "Cardio",
                    descripcion = "Camina sin moverte levantando las rodillas.", tiempoEstimado = 5),
                Ejercicio(workoutId = w2, orden = 2, nombre = "Jumping jacks", tipo = "Cardio",
                    descripcion = "Salta abriendo piernas y brazos a la vez.", tiempoEstimado = 4),
                Ejercicio(workoutId = w2, orden = 3, nombre = "Estiramientos", tipo = "Movilidad",
                    descripcion = "Estira piernas, espalda y brazos sin rebotes.", tiempoEstimado = 5)
            )

            val w3 = workoutDao.insert(
                Workout(
                    nombre = "Movilidad y estiramientos", nivel = 1,
                    video = "https://www.youtube.com/results?search_query=rutina+movilidad+y+estiramientos"
                )
            )
            ejercicioDao.insertAll(
                Ejercicio(workoutId = w3, orden = 1, nombre = "Rotación de hombros", tipo = "Movilidad",
                    descripcion = "Haz círculos amplios con los hombros hacia delante y hacia atrás.", tiempoEstimado = 3),
                Ejercicio(workoutId = w3, orden = 2, nombre = "Gato-camello", tipo = "Espalda",
                    descripcion = "A cuatro patas, arquea y redondea la espalda despacio.", tiempoEstimado = 3),
                Ejercicio(workoutId = w3, orden = 3, nombre = "Estiramiento de isquiotibiales", tipo = "Piernas",
                    descripcion = "Sentado con las piernas estiradas, lleva las manos hacia los pies.", tiempoEstimado = 4),
                Ejercicio(workoutId = w3, orden = 4, nombre = "Estiramiento de cuádriceps", tipo = "Piernas",
                    descripcion = "De pie, sujeta el empeine y lleva el talón hacia el glúteo.", tiempoEstimado = 3)
            )

            // ===== NIVEL 2 =====

            val w4 = workoutDao.insert(
                Workout(
                    nombre = "Fuerza tren superior", nivel = 2,
                    video = "https://www.youtube.com/results?search_query=rutina+tren+superior+mancuernas"
                )
            )
            ejercicioDao.insertAll(
                Ejercicio(workoutId = w4, orden = 1, nombre = "Flexiones", tipo = "Pecho",
                    descripcion = "Cuerpo recto, baja el pecho y empuja hacia arriba.", tiempoEstimado = 5),
                Ejercicio(workoutId = w4, orden = 2, nombre = "Remo con mancuerna", tipo = "Espalda",
                    descripcion = "Apoyado en un banco, sube la mancuerna hacia la cadera.", tiempoEstimado = 6),
                Ejercicio(workoutId = w4, orden = 3, nombre = "Press de hombros", tipo = "Hombro",
                    descripcion = "Sentado, sube las mancuernas hasta estirar los brazos.", tiempoEstimado = 6),
                Ejercicio(workoutId = w4, orden = 4, nombre = "Fondos en banco", tipo = "Tríceps",
                    descripcion = "Con las manos en un banco, baja y sube doblando los codos.", tiempoEstimado = 4)
            )

            // Workout SIN vídeo
            val w5 = workoutDao.insert(Workout(nombre = "Core y abdominales", nivel = 2))
            ejercicioDao.insertAll(
                Ejercicio(workoutId = w5, orden = 1, nombre = "Crunch", tipo = "Abdomen",
                    descripcion = "Tumbado, eleva los hombros sin tirar del cuello.", tiempoEstimado = 4),
                Ejercicio(workoutId = w5, orden = 2, nombre = "Plancha lateral", tipo = "Core",
                    descripcion = "De lado, sobre un antebrazo, con la cadera alta.", tiempoEstimado = 4),
                Ejercicio(workoutId = w5, orden = 3, nombre = "Elevación de piernas", tipo = "Abdomen",
                    descripcion = "Tumbado, sube las piernas rectas y bájalas despacio.", tiempoEstimado = 5),
                Ejercicio(workoutId = w5, orden = 4, nombre = "Bicicleta abdominal", tipo = "Abdomen",
                    descripcion = "Tumbado, lleva el codo hacia la rodilla contraria alternando.", tiempoEstimado = 4)
            )

            val w6 = workoutDao.insert(
                Workout(
                    nombre = "HIIT quemagrasa", nivel = 2,
                    video = "https://www.youtube.com/results?search_query=hiit+quemagrasa+en+casa"
                )
            )
            ejercicioDao.insertAll(
                Ejercicio(workoutId = w6, orden = 1, nombre = "Burpees", tipo = "Cardio",
                    descripcion = "Agáchate, lleva los pies atrás, vuelve y salta con los brazos arriba.", tiempoEstimado = 4),
                Ejercicio(workoutId = w6, orden = 2, nombre = "Mountain climbers", tipo = "Cardio",
                    descripcion = "En posición de plancha, lleva las rodillas al pecho alternando rápido.", tiempoEstimado = 4),
                Ejercicio(workoutId = w6, orden = 3, nombre = "Sentadilla con salto", tipo = "Piernas",
                    descripcion = "Haz una sentadilla y salta hacia arriba al subir.", tiempoEstimado = 4),
                Ejercicio(workoutId = w6, orden = 4, nombre = "Skipping", tipo = "Cardio",
                    descripcion = "Corre en el sitio subiendo las rodillas a la altura de la cadera.", tiempoEstimado = 3),
                Ejercicio(workoutId = w6, orden = 5, nombre = "Plancha con toque de hombro", tipo = "Core",
                    descripcion = "En plancha alta, toca el hombro contrario con cada mano sin mover la cadera.", tiempoEstimado = 4)
            )

            // ===== NIVEL 3 =====

            val w7 = workoutDao.insert(
                Workout(
                    nombre = "Piernas y glúteos", nivel = 3,
                    video = "https://www.youtube.com/results?search_query=rutina+piernas+gluteos+avanzada"
                )
            )
            ejercicioDao.insertAll(
                Ejercicio(workoutId = w7, orden = 1, nombre = "Zancadas", tipo = "Piernas",
                    descripcion = "Da un paso largo y baja hasta que la rodilla casi toque el suelo.", tiempoEstimado = 6),
                Ejercicio(workoutId = w7, orden = 2, nombre = "Sentadilla búlgara", tipo = "Piernas",
                    descripcion = "Con un pie apoyado detrás en un banco, baja y sube.", tiempoEstimado = 6),
                Ejercicio(workoutId = w7, orden = 3, nombre = "Puente de glúteos", tipo = "Glúteos",
                    descripcion = "Tumbado boca arriba, eleva la cadera apretando los glúteos.", tiempoEstimado = 5),
                Ejercicio(workoutId = w7, orden = 4, nombre = "Saltos al cajón", tipo = "Pliometría",
                    descripcion = "Salta encima de un cajón estable y baja con cuidado.", tiempoEstimado = 5)
            )

            val w8 = workoutDao.insert(
                Workout(
                    nombre = "Fuerza total avanzada", nivel = 3,
                    video = "https://www.youtube.com/results?search_query=rutina+fuerza+cuerpo+completo+avanzada"
                )
            )
            ejercicioDao.insertAll(
                Ejercicio(workoutId = w8, orden = 1, nombre = "Peso muerto con mancuernas", tipo = "Espalda",
                    descripcion = "Con la espalda recta, baja las mancuernas pegadas a las piernas y sube.", tiempoEstimado = 6),
                Ejercicio(workoutId = w8, orden = 2, nombre = "Press de banca con mancuernas", tipo = "Pecho",
                    descripcion = "Tumbado en un banco, empuja las mancuernas hacia arriba.", tiempoEstimado = 6),
                Ejercicio(workoutId = w8, orden = 3, nombre = "Dominadas", tipo = "Espalda",
                    descripcion = "Colgado de una barra, sube hasta que la barbilla pase la barra.", tiempoEstimado = 5),
                Ejercicio(workoutId = w8, orden = 4, nombre = "Sentadilla goblet", tipo = "Piernas",
                    descripcion = "Sujeta una mancuerna delante del pecho y haz la sentadilla.", tiempoEstimado = 6),
                Ejercicio(workoutId = w8, orden = 5, nombre = "Plancha con peso", tipo = "Core",
                    descripcion = "Plancha sobre antebrazos con un disco sobre la espalda.", tiempoEstimado = 4)
            )

            // Workout SIN vídeo
            val w9 = workoutDao.insert(Workout(nombre = "Resistencia y cardio intenso", nivel = 3))
            ejercicioDao.insertAll(
                Ejercicio(workoutId = w9, orden = 1, nombre = "Comba", tipo = "Cardio",
                    descripcion = "Salta a la comba a ritmo constante.", tiempoEstimado = 5),
                Ejercicio(workoutId = w9, orden = 2, nombre = "Sprints en el sitio", tipo = "Cardio",
                    descripcion = "Corre en el sitio a máxima velocidad durante 20 segundos y descansa 10.", tiempoEstimado = 4),
                Ejercicio(workoutId = w9, orden = 3, nombre = "Burpees con flexión", tipo = "Cardio",
                    descripcion = "Burpee completo añadiendo una flexión en el suelo.", tiempoEstimado = 5),
                Ejercicio(workoutId = w9, orden = 4, nombre = "Escaladores rápidos", tipo = "Core",
                    descripcion = "Mountain climbers al máximo ritmo manteniendo la plancha.", tiempoEstimado = 4)
            )
        }
    }
}