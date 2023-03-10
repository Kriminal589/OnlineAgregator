plugins {
    id("java")
}

allprojects {
    group = "org.online.aggregator"
    version = "1.0-SNAPSHOT"
}


repositories {
    mavenCentral()
}

dependencies {
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation(project(":Aggregator"))
    implementation(project(":Parser"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "WebApplication"
    }
}