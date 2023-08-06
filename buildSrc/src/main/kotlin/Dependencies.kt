import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    const val ANDROID_APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Androidx.APP_COMPAT}"
    const val ANDROID_CORE_KTX = "androidx.core:core-ktx:${Versions.Androidx.CORE_KTX}"
    const val ANDROID_WORK_MANAGER = "androidx.work:work-runtime-ktx:${Versions.Androidx.WORK_MANAGER}"
    const val ANDROID_BROWSER = "androidx.browser:browser:${Versions.Androidx.BROWSER}"
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.MATERIAL_ANDROID}"

    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.Compose.COMPOSE_ACTIVITY_VERSION}"
    const val COMPOSE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.COMPOSE_VIEWMODEL_VERSION}"
    const val COMPOSE_LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.Androidx.LIFECYCLE}"
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.Compose.COMPOSE_UI_VERSION}"
    const val COMPOSE_BOM = "androidx.compose:compose-bom:${Versions.Compose.COMPOSE_BOMB}"
    const val COMPOSE_UI_GRAPHIC = "androidx.compose.ui:ui-graphics:${Versions.Compose.COMPOSE_UI_VERSION}"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.COMPOSE_UI_VERSION}"
    const val COMPOSE_MATERIAL_3 = "androidx.compose.material3:material3:${Versions.Compose.COMPOSE_MATERIAL_3_VERESION}"
    const val COMPOSE_MATERIAL_2_ICON_CORE = "androidx.compose.material:material-icons-core:${Versions.Compose.COMPOSE_MATERIAL_2_VERSION}"
    const val COMPOSE_MATERIAL_2_ICON_EXTENED = "androidx.compose.material:material-icons-extended:${Versions.Compose.COMPOSE_MATERIAL_2_VERSION}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${Versions.NavigationCompose.NAVIGATION_COMPOSE_VERSION}"
    const val COMPOSE_WINDOW_SIZE_UTIL = "androidx.compose.material3:material3-window-size-class:${Versions.Compose.COMPOSE_MATERIAL_3_VERESION}"
    const val COIL_COMPOSE = "io.coil-kt:coil-compose:${Versions.COIL_COMPOSE_VERSION}"
    const val COMPOSE_PAGING_3 = "androidx.paging:paging-compose:${Versions.Compose.COMPOSE_PAGING_VERSION}"

    const val KOIN_CORE = "io.insert-koin:koin-core:${Versions.Koin.KOIN_ANDROID_VERSION}"
    const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.Koin.KOIN_ANDROID_VERSION}"
    const val KOIN_ANDROID_COMPAT = "io.insert-koin:koin-android-compat:${Versions.Koin.KOIN_ANDROID_VERSION}"
    const val KOIN_WORK_MANAGER = "io.insert-koin:koin-androidx-workmanager:${Versions.Koin.KOIN_ANDROID_VERSION}"
    const val KOIN_NAVIGATION = "io.insert-koin:koin-androidx-navigation:${Versions.Koin.KOIN_ANDROID_VERSION}"
    const val KOIN_COMPOSE = "io.insert-koin:koin-androidx-compose:${Versions.Koin.KOIN_ANDROIDX_COMPOSE_VERSION}"
    const val KOIN_TEST = "io.insert-koin:koin-test:${Versions.Koin.KOIN_ANDROID_VERSION}"
    const val KOIN_TEST_JUNIT_4 = "io.insert-koin:koin-test-junit4:${Versions.Koin.KOIN_ANDROID_VERSION}"
    const val KOIN_TEXT_JUNIT_5 = "io.insert-koin:koin-test-junit5:${Versions.Koin.KOIN_ANDROID_VERSION}"

    const val GMS_MAP = "com.google.android.gms:play-services-maps:${Versions.GMS_MAP}"
    const val CRASHLYTICS = "com.crashlytics.sdk.android:crashlytics:${Versions.CRASHLYTICS}"

    const val ANDROID_LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Androidx.LIFECYCLE}"
    const val ANDROID_LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.LIFECYCLE}"
    const val ANDROID_LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Androidx.LIFECYCLE}"
    const val ANDROID_LIFECYCLE_SAVED_STATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.Androidx.LIFECYCLE}"

    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"

    const val MOSHI = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val MOSHI_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI}"

    const val OKHTTP_BOM = "com.squareup.okhttp3:okhttp-bom:${Versions.OKHTTP3}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP3}"
    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP3}"

    const val KOTLINX_COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLIN_COROUTINE_CORE}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_ANDROID}"


    const val FIREBASE_CORE = "com.google.firebase:firebase-core:${Versions.Firebase.CORE}"
    const val FIREBASE_ADS = "com.google.firebase:firebase-ads:${Versions.Firebase.ADS}"
    const val FIREBASE_APP_INDEXING = "com.google.firebase:firebase-appindexing:${Versions.Firebase.APP_INDEX}"

    const val TEST_JUNIT = "junit:junit:${Versions.test.JUNIT}"
    const val TEST_ANDROID_EX_JUNIT = "androidx.test.ext:${Versions.test.JUNIT_EXT}"
    const val TEST_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.test.ESPRESSO_CORE}"
    const val TEST_COMPOSE_JUNIT_4 = "androidx.compose.ui:ui-test-junit4"
    const val DEBUG_COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.Compose.COMPOSE_UI_VERSION}"
    const val DEBUG_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.Compose.COMPOSE_UI_VERSION}"
}

fun DependencyHandler.firebase() {
    implementation(Dependencies.FIREBASE_CORE)
    implementation(Dependencies.FIREBASE_ADS)
    implementation(Dependencies.FIREBASE_APP_INDEXING)
}

fun DependencyHandler.koin() {
    compileOnly(Dependencies.KOIN_CORE)
    implementation(Dependencies.KOIN_ANDROID)
    implementation(Dependencies.KOIN_ANDROID_COMPAT)
    implementation(Dependencies.KOIN_WORK_MANAGER)
    implementation(Dependencies.KOIN_NAVIGATION)
    implementation(Dependencies.KOIN_COMPOSE)
    testImplementation(Dependencies.KOIN_TEST)
    testImplementation(Dependencies.KOIN_TEST_JUNIT_4)
    testImplementation(Dependencies.KOIN_TEXT_JUNIT_5)
}

fun DependencyHandler.appCompat() {
    implementation(Dependencies.ANDROID_APP_COMPAT)
    implementation(Dependencies.ANDROID_CORE_KTX)
}

fun DependencyHandler.coroutine() {
    implementation(Dependencies.COROUTINES_ANDROID)
    implementation(Dependencies.KOTLINX_COROUTINES_CORE)
}

fun DependencyHandler.lifecycle() {
    implementation(Dependencies.ANDROID_LIFECYCLE_RUNTIME)
    implementation(Dependencies.ANDROID_LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.ANDROID_LIFECYCLE_LIVEDATA)
    implementation(Dependencies.ANDROID_LIFECYCLE_SAVED_STATE)
}

fun DependencyHandler.jetpackCompose() {
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(Dependencies.COMPOSE_VIEWMODEL)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_UI_GRAPHIC)
    implementation(Dependencies.COMPOSE_PREVIEW)
    implementation(Dependencies.COMPOSE_MATERIAL_3)
    implementation(Dependencies.COMPOSE_NAVIGATION)
    implementation(Dependencies.COMPOSE_MATERIAL_2_ICON_CORE)
    implementation(Dependencies.COMPOSE_MATERIAL_2_ICON_EXTENED)
    implementation(Dependencies.COMPOSE_WINDOW_SIZE_UTIL)
    implementation(Dependencies.COMPOSE_LIFECYCLE_RUNTIME)
    implementation(Dependencies.COMPOSE_PAGING_3)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER_MOSHI)
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.OKHTTP_LOGGER)
}

fun DependencyHandler.moshi() {
    implementation(Dependencies.MOSHI)
    ksp(Dependencies.MOSHI_CODEGEN)
}

fun DependencyHandler.coilCompose() {
    implementation(Dependencies.COIL_COMPOSE)
}

fun DependencyHandler.test() {
    testImplementation(Dependencies.TEST_JUNIT)
    androidTestImplementation(Dependencies.TEST_ANDROID_EX_JUNIT)
    androidTestImplementation(Dependencies.TEST_ESPRESSO_CORE)
    androidTestImplementation(Dependencies.TEST_COMPOSE_JUNIT_4)
}

fun DependencyHandler.testCompose() {
    debugImplementation(Dependencies.DEBUG_COMPOSE_TOOLING)
    debugImplementation(Dependencies.DEBUG_TEST_MANIFEST)
}

fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}

private fun DependencyHandler.ksp(depName: String) {
    add("ksp", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}