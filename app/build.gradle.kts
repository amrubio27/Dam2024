plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.navigation.safeargs.kotlin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "edu.iesam.dam2024"
    compileSdk = 35

    defaultConfig {
        applicationId = "edu.iesam.dam2024"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Gson
    implementation(libs.converter.gson)
    // Glide
    implementation(libs.glide)
    // Coil
    implementation(libs.coil)
    //Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // Navigation
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    //Navigation KTX
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.fragment.ktx)
    //Koin
    implementation(libs.koin.android)
    implementation(libs.koin.test)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.ksp.compiler)
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp.compiler)

}