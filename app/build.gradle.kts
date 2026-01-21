plugins {
    application
    id("com.diffplug.spotless") version "6.25.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit)
    implementation(libs.guava)
    implementation(libs.dagger)
    annotationProcessor(libs.dagger.compiler)
}

spotless {
    java {
        googleJavaFormat("1.33.0")
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "org.example.CommandLineAtm"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}