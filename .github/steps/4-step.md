
## Step 4: Inicializa Koin en cada plataforma

> **Importante:** Realiza todos los pasos del ejercicio en un solo branch de trabajo llamado `feature/koin-kmp`.

Ya tienes tus módulos de Koin listos. Ahora debes inicializar Koin en el punto de entrada de cada plataforma para que la inyección de dependencias funcione correctamente.

### 📖 Teoría: ¿Por qué inicializar Koin en cada plataforma?

<!--
> [!TIP]
> Inicializar Koin en el punto de entrada de cada plataforma asegura que todas las dependencias estén disponibles desde el inicio de la aplicación.
-->

En proyectos multiplataforma, cada plataforma (Android, iOS) tiene su propio ciclo de vida y punto de entrada. Por eso, la inicialización de Koin debe hacerse en cada uno de ellos.

### ⌨️ Actividad: Inicializa Koin en Android e iOS

1. **Android:**
   - Crea una clase `MainApplication` que extienda de `Application` si no la tienes ya en `KMPKoin/androidApp/src/main/kotlin/io/github/kevinah95/kmpkoin/MainApplication.kt`:
     ```kotlin
     package io.github.kevinah95.kmpkoin

     import android.app.Application

     class MainApplication : Application() {
         override fun onCreate() {
             super.onCreate()
             // Aquí inicializaremos Koin
         }
     }
     ```
   - Abre `KMPKoin/androidApp/src/main/kotlin/io/github/kevinah95/kmpkoin/MainApplication.kt`.
   - Llama a `initKoin()` en el método `onCreate` de tu clase `Application`:
     ```kotlin
     class MainApplication : Application() {
         override fun onCreate() {
             super.onCreate()
             initKoin()
         }
     }
     ```
   - No olvides registrar tu clase `MainApplication` en el `AndroidManifest.xml`:
     ```xml
     <application
         android:name=".MainApplication"
         ... >
         <!-- otras configuraciones -->
     </application>
     ```
3. Verifica que la app arranca sin errores y que puedes inyectar dependencias en ambas plataformas.

<details>
<summary>Having trouble? 🤷</summary><br/>

- Si tienes problemas en Android, revisa que tu clase `Application` esté registrada en el `AndroidManifest.xml`.
- Si tienes problemas en iOS, revisa la integración entre Swift y Kotlin Multiplatform.
- Consulta la [documentación oficial de Koin](https://insert-koin.io/docs/setup/v4) para más detalles sobre inicialización multiplataforma.

</details>
