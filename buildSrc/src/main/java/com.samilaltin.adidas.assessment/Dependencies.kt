object Dependencies {

    /** android supports */
    val material = "com.google.android.material:material:${Versions.materialVersion}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintVersion}"

    /** architecture components */
    val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    val lifecycleSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleVersion}"
    val archComponent = "androidx.arch.core:core-testing:${Versions.archComponentVersion}"

    /** startup */
    val startup = "androidx.startup:startup-runtime:${Versions.startupVersion}"

    /** hilt */
    val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltCoreVersion}"
    val hiltCommon = "androidx.hilt:hilt-common:${Versions.hiltVersion}"
    val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltVersion}"
    val assistedInjectAnnotations = "com.squareup.inject:assisted-inject-annotations-dagger2:${Versions.assistedInjectVersion}"
    val assistedInjectProcessor = "com.squareup.inject:assisted-inject-processor-dagger2:${Versions.assistedInjectVersion}"
    val daggerHiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltCoreVersion}"
    val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltVersion}"
    val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.hiltCoreVersion}"

    /** network */
    val sandwich = "com.github.skydoves:sandwich:${Versions.sandwichVersion}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttpVersion}"

    /** moshi */
    val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"

    /** coroutines */
    val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    val kotlinxCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"

    /** glide */
    val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

    /** debugging */
    val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"

    /** unit test */
    val junit = "junit:junit:${Versions.junitVersion}"
    val core =  "androidx.test:core:${Versions.androidxTest}"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
    val turbine = "app.cash.turbine:turbine:${Versions.turbineVersion}"
    val robolectric = "org.robolectric:robolectric:${Versions.robolectricVersion}"
    val truth = "com.google.truth:truth:${Versions.truthVersion}"
    val androidxTestJunit =  "androidx.test.ext:junit:${Versions.androidxTestJunit}"
    val runner = "com.android.support.test:runner:${Versions.androidTestRunner}"
    val espresso =  "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"

}