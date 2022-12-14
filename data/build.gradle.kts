plugins {
    id(Config.Plugins.library)
    id(Config.Plugins.kotlin)
    id(Config.Plugins.kapt)
    id(Config.Plugins.hilt)
}

android {
    compileSdk = Config.Version.compileSdk

    defaultConfig {
        minSdk = Config.Version.minSdk
        targetSdk = Config.Version.targetSdk
        testInstrumentationRunner = Config.Android.Test.jUnitRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(Config.Modules.domain))

    implementation(Config.Square.retrofit)
    implementation(Config.Square.retrofitGsonConverter)

    implementation(Config.Android.Room.runtime)
    annotationProcessor(Config.Android.Room.compiler)

    kapt(Config.Android.Hilt.hiltAndroidCompiler)
    kapt(Config.Android.Hilt.hiltCompiler)
    implementation(Config.Android.Hilt.hiltAndroid)
    implementation(Config.Android.Hilt.hiltLifecycleViewModel)

    testImplementation(Config.Android.Test.mockk)
    testImplementation(Config.Kotlin.Coroutine.coroutineTest)
    testImplementation(Config.Android.Test.core)
}