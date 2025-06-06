plugins {
    java
    id("org.springframework.boot") version "3.2.0"

    // OPTIONAL: Only include if you're managing dependency versions manually
    // Safe to remove if you rely solely on Spring Boot's dependency management
    id("io.spring.dependency-management") version "1.1.3"
}

group = "com.example"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot web starter
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Spring Boot test starter
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        // Exclude JUnit 4 to fully use JUnit 5
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

    // Explicit JUnit 5 dependencies (required for Gradle 9 compatibility)
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
