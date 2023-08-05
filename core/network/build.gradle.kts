plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    namespace = "com.exam.application.network"
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
    ConfigurationData.jvmTarget
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core:util"))
    implementation(project(":core:data"))

    coroutine()
    lifecycle()
    koin()

    retrofit()
    implementation(platform(Dependencies.OKHTTP_BOM))
    moshi()

    test()

    implementation(Dependencies.TIMBER)
}