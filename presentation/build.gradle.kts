plugins {
    id(Plugins.application)
    id(Plugins.kotlin)
    id(Plugins.kapt)
    id(Plugins.hilt)
}

android {
    compileSdk = Version.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Version.minSdk
        targetSdk = Version.targetSdk
        versionCode = Version.versionCode
        versionName = Version.versionName
        testInstrumentationRunner = Config.Test.jUnitRunner
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
        jvmTarget ="1.8"
    }
}

dependencies {
    implementation(project(Modules.data) )
    implementation(project(Modules.domain))

    implementation(Config.Hilt.hiltAndroid)
    kapt(Config.Hilt.hiltAndroidCompiler)
    kapt(Config.Hilt.hiltCompiler)
    implementation(Config.Hilt.hiltLifecycleViewModel)

    implementation(Config.Kotlin.Coroutine.coroutines)
    testImplementation(Config.Kotlin.Coroutine.coroutineTest)

    implementation(Config.Google.playServiceAuth)
    implementation(Config.Google.playServiceLocation)
    implementation(Config.Google.gson)

    implementation(Config.Square.otto)
    implementation(Config.Square.retrofit)
    implementation(Config.Square.retrofitGsonConverter)
    implementation(Config.Square.retrofitRxJava3Adapter)
    implementation(Config.Square.okhttp)
    implementation(Config.Square.okhttpLogging)

    implementation(Config.Android.Lifecycle.viewModel)

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}