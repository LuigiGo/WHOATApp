# WHOATApp
Below are the frameworks and libraries used to develop WHOAT Application

## Gson
This framework is used for converting JSON into Kotlin objects or vice versa. This can be used for parsing request and response from web services calls. 

    implementation "com.google.code.gson:gson:2.8.6"

## Coroutines
This is used for performing long running task and handling threads while operating asynchronous API calls within the application.

    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7'
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0"``

## Retrofit
This REST client is used for consuming and managing web services calls.

    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation 'com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2'``

## ViewModel
It is used to support the MVVM design pattern implementation. The MVVM focuses on separation of the views, business logic and back-end logic. As part of the MVVM, the ViewModel is responsible in managing states and UI related data in a much convenient way such as when the application is in configuration changes state. 

    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    //noinspection LifecycleAnnotationProcessorWithJava8
    kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"

## KodeIn
This is used for implementing dependency injection in the application. The main focus of this framework is to reduce the tight coupling of the objects and classes in the application. Using this technique, modules and features can be easily modified or change without affecting other non-required classes. 

Note: Dagger2, can be also used for implementing dependency injection. I considered to use the KodeIn framework for the examination purposes, since it is much simple to implement.    

    implementation "org.kodein.di:kodein-di-generic-jvm:$kodein_version"
    implementation "org.kodein.di:kodein-di-framework-android-x:$kodein_version"

## Glide
It is used for loading local resource or image URLs. It is capable of fast, efficient and performant handling errors and issues while loading the images.

    implementation "com.github.bumptech.glide:glide:$glide_version"
    kapt "com.github.bumptech.glide:compiler:$glide_version"

## Material Component
This dependency allows to use the new Material Design components for much better presentation and look and feel of the graphical user interface such as buttons, cardviews etc. 

    implementation "com.google.android.material:material:1.2.1"

## OkHttp Logging Interceptor
This is used for logging the information about the request and responses from web services calls

    implementation 'com.squareup.okhttp3:logging-interceptor:4.2.1'

## PageIndicator
This library is used for implementing the recyclerviews indicator. It can easily change the design of the indicators like colors, height and width of the indicators, etc.  

    implementation 'me.relex:circleindicator:2.1.4'

## JUnit 4 framework
This framework allows test creation for every functionality implemented in the application

    testImplementation 'junit:junit:4.13.1'

## Mockito
This framework is also used to test functionality of the application by mocking it's objects and classes  

    testImplementation 'org.mockito:mockito-core:2.19.0'
    testImplementation 'org.mockito:mockito-inline:2.13.0'
    
## Truth assertion
It is used to implement assertions for every test function created. It can work together with the JUnit and Mockito framework.

    testImplementation "com.google.truth:truth:1.1"
    testImplementation 'android.arch.core:core-testing:2.1.0'
