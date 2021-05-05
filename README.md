# adidas-assessment

Assesment for Adidas, coded by Kotlin for Android platform.

## About

**Adidas Assessment** is a simple Android application which displays products, product detail and reviews from created docker environment that run in local machine.
This local ip address endpoint can be changed from NetworkModule class.
NetworkModule provides 2 retrofit for products and posting review.

## Install  

- Clone repository
- Run the app (minimum SDK version 21)

## Rendered data  

Application consist of two pages with one bottom sheet

Main page - showing list of:  

- Product Image (thumbnail)
- Product Name
- Product Description
- Product Price

Product Detail page:

- Product Image  
- Product Name - Product Id
- Product Price
- Calculated Average Rating
- Reviews

Add Review page (Bottom Sheet):

- Rating Bar
- Review Field

## Architecture  

MVVM with Repository pattern  
(View - DataBinding - ViewModel - Model)  
  
## Tech stack - Libraries

- Kotlin, Coroutines, Flow
- Hilt for dependency injection.
- Gradle Kotlin DSL
- [Architecture Components](https://developer.android.com/arch)
- [Material](https://material.io/develop/android/docs/getting-started)  
- [Android Databinding](https://developer.android.com/topic/libraries/data-binding/index.html)  
- [Dagger Hilt](https://dagger.dev/hilt/) for dependency injection  
- [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) + Flow   
- [Glide](https://github.com/bumptech/glide) for image loading  
- [OkHttp & Retrofit](https://square.github.io/retrofit/) for network calls
- [Moshi](https://github.com/square/moshi/) JSON library
- [Mockito](https://github.com/nhaarman/mockito-kotlin) for mocking with Kotlin
- [Truth](https://github.com/google/truth) for AndroidTests
