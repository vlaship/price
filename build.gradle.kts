import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

    // Kotlin
    val kotlinVersion = "1.3.31"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion

//    // id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
//    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    // Spring
    id("org.springframework.boot") version "2.1.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"

    // Utils
    idea
}

group = "vlaship.price"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    // Spring
    // implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // implementation("org.springframework.boot:spring-boot-starter-security")
    // implementation("org.springframework.boot:spring-boot-starter-web")
    // runtimeOnly("org.springframework.boot:spring-boot-devtools")

    // // JWT
    // val jwtVersion = "0.10.+"
    // api("io.jsonwebtoken:jjwt-api:$jwtVersion")
    // runtimeOnly("io.jsonwebtoken:jjwt-impl:$jwtVersion")
    // runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jwtVersion")

    // Kotlin
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // // DB
    // runtimeOnly("mysql:mysql-connector-java")
    // runtimeOnly("org.flywaydb:flyway-core")

    // // Swagger
    // val swaggerVersion = "2.9.+"
    // implementation("io.springfox:springfox-swagger2:$swaggerVersion")
    // implementation("io.springfox:springfox-bean-validators:$swaggerVersion")
    // runtimeOnly("io.springfox:springfox-swagger-ui:$swaggerVersion")

    // // Tests
    // testImplementation("org.springframework.boot:spring-boot-starter-test") {
    //     exclude(group = "org.mockito")
    // }
    // testImplementation("org.springframework.security:spring-security-test")
    // testImplementation("org.amshove.kluent:kluent:1.+")
    // testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.+")
    // testRuntimeOnly("com.h2database:h2")
    // testRuntimeOnly("org.apache.httpcomponents:httpclient")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

springBoot.buildInfo()

idea.module {
    isDownloadJavadoc = true
    isDownloadSources = true
}
