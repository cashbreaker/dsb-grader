plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "one.piotrowski"
version = "0.0.1-SNAPSHOT"

val labradoorVersion = "1.4.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://gitlab.ewi.tudelft.nl/api/v4/projects/3611/packages/maven")
    }
    maven {
        url = uri("https://gitlab.ewi.tudelft.nl/api/v4/projects/3710/packages/maven")
    }
    maven {
        url = uri("https://gitlab.ewi.tudelft.nl/api/v4/projects/8633/packages/maven")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("nl.tudelft.labrador:labradoor:$labradoorVersion") {
        exclude("org.springframework.boot", "spring-boot-devtools")
    }
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootBuildImage {
    builder.set("paketobuildpacks/builder-jammy-base:latest")
}
