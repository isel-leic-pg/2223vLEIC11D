plugins {
    kotlin("jvm") version "1.8.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.github.palex65:CanvasLib-jvm:1.0.2")
}

tasks.test {
    useJUnitPlatform()
}
/*
kotlin {
    jvmToolchain(18)
}
*/