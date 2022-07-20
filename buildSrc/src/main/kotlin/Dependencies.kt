object Config {
    const val applicationId = "base.architecture"

    object Android {
        const val androidGradle = "com.android.tools.build:gradle:7.0.2"

        object Lifecycle {
            private const val lifecycleVersion = "2.3.1"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
            const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
            const val service = "androidx.lifecycle:lifecycle-service:$lifecycleVersion"
            const val process = "androidx.lifecycle:lifecycle-process:$lifecycleVersion"
            const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:$lifecycleVersion"
            const val lifecycleTest = "androidx.arch.core:core-testing:2.1.0"
        }
    }

    object Test {
        const val jUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Hilt {
        private const val hiltVersion = "2.38.1"
        const val hiltAndroidGradle = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
        const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
        const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    }

    object Google {
        const val googleServiceGradle = "com.google.gms:google-services:4.3.10"
        const val material = "com.google.android.material:material:1.4.0"
        const val playService = "com.google.android.gms:play-services-base:17.6.0"
        const val playServiceAuth = "com.google.android.gms:play-services-auth-api-phone:17.5.1"
        const val playServiceLocation = "com.google.android.gms:play-services-location:18.0.0"
        const val gson = "com.google.code.gson:gson:2.8.8"
    }

    object Kotlin {
        private const val kotlinVersion = "1.5.30"

        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        const val stdLibJDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2"

        object Coroutine {
            private const val coroutineVersion = "1.5.2"
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
            const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion"
        }
    }

    object Square {
        private const val retrofitVersion = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val retrofitRxJava3Adapter = "com.squareup.retrofit2:adapter-rxjava3:$retrofitVersion"
        const val retrofitRxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"

        const val otto = "com.squareup:otto:1.3.8"

        private const val okhttpVersion = "4.9.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
    }
}

object Plugins {
    const val application = "com.android.application"
    const val library = "com.android.library"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val hilt = "dagger.hilt.android.plugin"
    const val kapt = "kotlin-kapt"
}

object Version {
    const val buildToolVersion = "30.0.3"
    const val ndkVersion = "21.3.6528147"

    const val minSdk = 21
    const val compileSdk = 31
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "0.0.1"
}

object Modules {
    const val data = ":data"
    const val domain = ":domain"
    const val presentation = ":presentation"
}
