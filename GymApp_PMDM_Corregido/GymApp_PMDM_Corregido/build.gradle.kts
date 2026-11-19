// Archivo de Gradle del PROYECTO.
// Aquí solo se DECLARAN los plugins (con "apply false").
// Cada módulo (en nuestro caso, :app) los ACTIVA en su propio build.gradle.kts.
plugins {
    // Plugin de Android para crear una aplicación
    alias(libs.plugins.android.application) apply false

    // Safe Args: genera clases para navegar y pasar datos entre Fragments (UD2.7)
    alias(libs.plugins.navigation.safeargs) apply false

    // kapt: procesa las anotaciones de ROOM (@Entity, @Dao, @Database)
    // En AGP 9 sustituye al antiguo "kotlin-kapt" del tema UD4.2
    alias(libs.plugins.legacy.kapt) apply false
}