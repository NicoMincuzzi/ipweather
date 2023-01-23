import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.7.0"
    kotlin("plugin.spring") version "1.7.0"
    jacoco
}

group = "com.github.nicomincuzzi"
version = "0.1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("org.projectlombok:lombok:1.18.24")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.3") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.mockk:mockk:1.12.4")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.33.2")
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
        csv.isEnabled = false
    }
    dependsOn(tasks.test) // tests are required to run before generating the report
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}
