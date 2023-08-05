plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    namespace = "com.exam.application.feature.newsdetail"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
         minSdk = ConfigurationData.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = ConfigurationData.jvmTarget
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = ConfigurationData.KotlinCompilerExtensionVersion
    }
}

dependencies {
    implementation(project(":core:util"))
    implementation(project(":core:data"))
    implementation(project(":core:resource"))
    implementation(project(":core:ui"))
    implementation(project(":data:newsdata"))
    implementation(project(":domain:newsdetail"))


    appCompat()
    coroutine()
    lifecycle()
    koin()

    jetpackCompose()
    implementation(platform(Dependencies.COMPOSE_BOM))

    implementation(Dependencies.TIMBER)

    test()
    androidTestImplementation(platform(Dependencies.COMPOSE_BOM))
    testCompose()
}