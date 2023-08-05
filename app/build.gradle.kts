import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    namespace = "com.exam.application.newscompose"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        applicationId = ConfigurationData.applicationId
        minSdk = ConfigurationData.minSdk
        targetSdk = ConfigurationData.targetSdk
        versionCode = ConfigurationData.versionCode
        versionName = ConfigurationData.versionName

        buildConfigField(type = "String", name = "API_KEY", value = "${project.properties["API_KEY"]}")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            buildConfigField(type = "String", name = "BASE_URL", value = "\"https://newsapi.org/\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = false
            buildConfigField(type = "String", name = "BASE_URL", value = "\"https://newsapi.org/\"")
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":core:resource"))
    implementation(project(":core:util"))
    implementation(project(":feature:newsfeed"))
    implementation(project(":feature:newsdetail"))

    appCompat()
    coroutine()
    lifecycle()
    koin()

    retrofit()
    implementation(platform(Dependencies.OKHTTP_BOM))
    moshi()

    jetpackCompose()
    implementation(platform(Dependencies.COMPOSE_BOM))

    implementation(Dependencies.TIMBER)

    test()
    androidTestImplementation(platform(Dependencies.COMPOSE_BOM))
    testCompose()

}