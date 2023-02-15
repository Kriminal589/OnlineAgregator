plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    implementation("mysql:mysql-connector-java:8.0.30")
    implementation("org.flywaydb:flyway-mysql:9.11.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.1")

    implementation("org.springframework.boot:spring-boot-starter-web:3.0.1")
    implementation("com.google.code.gson:gson:2.10.1")
    compileOnly("org.projectlombok:lombok:1.18.24")

    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.2")

    implementation(project(":DBConnection"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}