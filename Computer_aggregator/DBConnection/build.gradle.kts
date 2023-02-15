plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:23.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    implementation("org.flywaydb:flyway-core:9.11.0")
    implementation("mysql:mysql-connector-java:8.0.30")
    implementation("org.flywaydb:flyway-mysql:9.11.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}