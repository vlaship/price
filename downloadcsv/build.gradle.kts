import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "vlaship.price"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.apache.httpcomponents:httpclient:4.5.8")
    implementation("org.springframework.boot:spring-boot-starter")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}