plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

//    implementation("org.jsoup:jsoup:1.15.3")
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
    implementation("org.seleniumhq.webdriver:webdriver-common:0.9.7376")
    implementation("io.github.bonigarcia:webdrivermanager:5.3.2")


    implementation(project(":Aggregator"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}