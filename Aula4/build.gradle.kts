plugins {
    kotlin("jvm") version "1.8.0"
}

group = "pt.isel.pg.v2223"
version = "1.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}