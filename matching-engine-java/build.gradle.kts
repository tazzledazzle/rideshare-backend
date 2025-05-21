plugins {
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}
dependencies {
    implementation(project(":common"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.postgresql:postgresql:42.5.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}