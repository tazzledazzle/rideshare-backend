
plugins {
    kotlin("jvm").version("2.1.20") apply false
    id("org.springframework.boot").version("3.4.3") apply false
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
tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_23.toString()
    targetCompatibility = JavaVersion.VERSION_23.toString()
}