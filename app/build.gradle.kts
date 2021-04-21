plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        applicationId = "com.androidsystems.whoatapp"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        correctErrorTypes = true
    }
    testOptions {
//        unitTests.includeAndroidResources = true
        unitTests.apply {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

val kotlinVersion by extra { "1.4.10" }
val kodeInVersion by extra { "5.2.0" }
val lifecycleVersion by extra { "2.2.0" }
val retrofitVersion by extra { "2.4.0" }
val glideVersion by extra { "4.8.0" }
val epoxyVersion by extra { "3.9.0" }


dependencies {
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.core:core-ktx:1.3.2")

    // Gson
    implementation("com.google.code.gson:gson:2.8.6")

    // Kotlin Android Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    //noinspection LifecycleAnnotationProcessorWithJava8
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")

    // Kodein
    implementation("org.kodein.di:kodein-di-generic-jvm:$kodeInVersion")
    implementation("org.kodein.di:kodein-di-framework-android-x:$kodeInVersion")

    // Glide
    implementation("com.github.bumptech.glide:glide:$glideVersion")
    kapt("com.github.bumptech.glide:compiler:$glideVersion")

    // New Material Design
    implementation("com.google.android.material:material:1.2.1")

    // OkHttp Logging Interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:4.2.1")

    // PageIndicator
    implementation("me.relex:circleindicator:2.1.4")

    // JUnit 4 framework
    testImplementation("junit:junit:4.13.1")

    // Robolectric environment
    testImplementation("androidx.test:core:1.3.0")

    // Mockito
    testImplementation("org.mockito:mockito-core:2.19.0")
    testImplementation("org.mockito:mockito-inline:2.13.0")

    // Truth assertion
    testImplementation("com.google.truth:truth:1.1")
    testImplementation("android.arch.core:core-testing:2.1.0")

    // Epoxy
    implementation("com.airbnb.android:epoxy:$epoxyVersion")
    kapt("com.airbnb.android:epoxy-processor:$epoxyVersion")

    // Navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.4")

    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    // MvRx
    implementation("com.airbnb.android:mavericks:2.2.0")
}