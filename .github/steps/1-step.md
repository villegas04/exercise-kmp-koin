
# Step 1: Agrega las dependencias de Koin usando Version Catalog

> **Importante:** Realiza todos los pasos del ejercicio en un solo branch de trabajo llamado `feature/koin-kmp`. No mezcles los cambios a `main` hasta terminar el ejercicio y pasar la revisión.

Ahora que conoces la estructura del proyecto, el siguiente paso es agregar Koin para la inyección de dependencias utilizando el Version Catalog (`libs.versions.toml`) y el BOM de Koin (Bill of Materials) versión 4.

### 📖 Teoría: ¿Por qué usar Version Catalog y BOM?

<!--
> [!TIP]
> El Version Catalog centraliza y simplifica la gestión de versiones de dependencias. El BOM de Koin asegura que todas las dependencias de Koin sean compatibles entre sí.
-->

En proyectos modernos, es recomendable definir las versiones y módulos de dependencias en `libs.versions.toml` para mantener el proyecto organizado y fácil de actualizar.

### ⌨️ Actividad: Añade Koin a tu proyecto con Version Catalog

1. Abre el archivo `KMPKoin/gradle/libs.versions.toml` y asegúrate de tener las siguientes líneas:
   ```toml
   [versions]
   koin-bom = "4.2.2"
   # ...otras versiones

   [libraries]
   # Koin
   koin-bom = { module = "io.insert-koin:koin-bom", version.ref = "koin-bom" }
   koin-core = { module = "io.insert-koin:koin-core" }
   koin-android = { module = "io.insert-koin:koin-android" }
   koin-compose = { module = "io.insert-koin:koin-compose" }
   koin-compose-viewmodel = { module = "io.insert-koin:koin-compose-viewmodel" }
   koin-compose-viewmodel-navigation = { module = "io.insert-koin:koin-compose-viewmodel-navigation" }
   koin-test = { module = "io.insert-koin:koin-test" }
   # ...otras dependencias de Koin si las necesitas
   ```
2. **⚠️ Este punto es muy importante: Sincroniza el proyecto para descargar las dependencias antes de continuar.**
3. En los archivos `build.gradle.kts` de los módulos `shared`, agrega las dependencias de Koin usando el catalog:
   ```kotlin
   // shared/build.gradle.kts
   kotlin {
       sourceSets {
           commonMain.dependencies {
               // ... otras dependencias
               implementation(project.dependencies.platform(libs.koin.bom))
               implementation(libs.koin.core)
               implementation(libs.koin.compose)
               implementation(libs.koin.compose.viewmodel)
               implementation(libs.koin.compose.viewmodel.navigation)
           }
       }
   }
   ```

<details>
<summary>Having trouble? 🤷</summary><br/>

- Si tienes errores de sincronización, revisa que la versión de Koin sea compatible con tu versión de Kotlin.
- Consulta la [documentación oficial de Koin](https://insert-koin.io/docs/setup/gradle#kotlin-multiplatform) para más detalles sobre integración multiplataforma y uso de BOM.

</details>
