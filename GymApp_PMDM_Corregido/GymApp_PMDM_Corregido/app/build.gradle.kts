// Archivo de Gradle del MÓDULO app.
// Aquí se activan los plugins y se añaden las librerías que usa la app.
plugins {
    // Plugin de Android para crear una aplicación
    alias(libs.plugins.android.application)

    // Safe Args: genera las clases ...Directions para navegar con datos (UD2.7)
    alias(libs.plugins.navigation.safeargs)

    // kapt: lee las anotaciones de ROOM y genera el código de la base de datos (UD4.2)
    alias(libs.plugins.legacy.kapt)
}

android {
    // Paquete de la app (donde están las clases Kotlin)
    namespace = "es.elorrieta.gymapp"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "es.elorrieta.gymapp"
        minSdk = 24          // Android 7.0 como mínimo
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Librerías básicas que ya traía la plantilla
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.recyclerview)
    implementation(libs.material)

    // Navigation Component + Fragments (UD2.6 y UD2.7)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.fragment.ktx)

    // ROOM (UD4.2)
    implementation(libs.androidx.room.runtime)   // la base de datos
    implementation(libs.androidx.room.ktx)       // soporte de corrutinas
    kapt(libs.androidx.room.compiler)          // procesador de anotaciones (solo al compilar)

    // Pruebas (las añade la plantilla)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}