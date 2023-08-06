plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.exam.application.domain.newsfeed"
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
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core:util"))
    implementation(project(":core:data"))
    implementation(project(":core:network"))
    implementation(project(":data:newsdata"))


    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.6.0")
    coroutine()
    lifecycle()
    koin()

    retrofit()
    implementation(platform(Dependencies.OKHTTP_BOM))
    moshi()

    test()

    implementation(Dependencies.TIMBER)
}