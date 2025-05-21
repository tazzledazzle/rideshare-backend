
plugins {
    kotlin("jvm").version("2.1.20") apply false
    id("org.springframework.boot").version("2.7.0") apply false
}
allprojects {
    group = "com.rideshare"
    version = "0.1.0"
    repositories { mavenCentral() }
}
// subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_23)
        }
    }
// }

// kotlin {
    // jvmToolchain {
    //     languageVersion.set(JavaLanguageVersion.of("23"))
    // }
    // Or shorter:
    // jvmToolchain(23)
    // For example:
    // jvmToolchain(17)
// }