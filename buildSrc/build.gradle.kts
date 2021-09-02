
plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    val magikVersion = "0.1.9"
    implementation("elect86.magik:elect86.magik.gradle.plugin:$magikVersion")

//    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:$embeddedKotlinVersion")
}