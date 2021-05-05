object Classpaths {
    val gradleClasspath = "com.android.tools.build:gradle:${Versions.gradleBuildTool}"
    val kotlinGradleClasspath = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val gradleVersionPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.versionPlugin}"
    val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltCoreVersion}"
    val spotlessGradlePlugin = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotlessGradle}"
}