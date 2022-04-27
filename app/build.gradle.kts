import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow")
    application
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.0.0")
    implementation("io.ktor:ktor-server-netty:2.0.0")

    implementation("io.ktor:ktor-server-metrics-micrometer:2.0.0")
    implementation("io.micrometer:micrometer-registry-prometheus:1.8.5")

    implementation("com.sksamuel.hoplite:hoplite-yaml:2.1.2")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    runtimeOnly("net.logstash.logback:logstash-logback-encoder:7.1.1")

    implementation("org.apache.kafka:kafka-streams:3.1.0")
    implementation("org.apache.kafka:kafka-clients:3.1.0")
    implementation("io.confluent:kafka-streams-avro-serde:7.0.1") {
        exclude("org.apache.kafka", "kafka-clients")
    }

    implementation("no.nav.aap.avro:inntekter:0.0.11")

    // JsonSerializer java 8 LocalDate
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.2")

    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-test-host:2.0.0")
    // used to override env var runtime
    testImplementation("uk.org.webcompere:system-stubs-jupiter:2.0.1")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "18"
    }

    withType<Test> {
        useJUnitPlatform()
    }
}

application {
    // Define the main class for the application.
    mainClass.set("no.nav.aap.AppKt")
}
