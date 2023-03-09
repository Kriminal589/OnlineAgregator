plugins {
    id("java")
    id("org.springframework.boot") version "2.6.7"
    id ("io.spring.dependency-management") version "1.0.10.RELEASE"
}

allprojects {
    group = "org.online.aggregator"
    version = "1.0-SNAPSHOT"
}


repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java")
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

tasks.register<Jar>("uber") {
    archiveClassifier.set("uber")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

tasks.bootBuildImage {
    enabled = false
}