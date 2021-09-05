plugins {
    application
    id("org.kordamp.gradle.jandex") version "0.11.0"
}

repositories {
    mavenCentral()
}

val helidonVersion = "2.3.2"

dependencies {

    implementation(platform("io.helidon:helidon-dependencies:${helidonVersion}"))

    implementation("io.helidon.microprofile.bundles:helidon-microprofile")
    implementation("io.helidon.media:helidon-media-jackson")

    runtimeOnly("org.jboss:jandex")
    runtimeOnly("com.sun.activation:javax.activation:1.2.0")

    testCompileOnly("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
}

application {
    // Define the main class for the application.
    mainClass.set("dev.rmuhamedgaliev.App")
}

tasks.test {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}