plugins { 
    kotlin("jvm")
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
}
dependencies {
    implementation("org.springframework.boot:spring-boot-starter:3.4.5")
    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
    implementation("org.springframework.data:spring-data-commons:3.4.5")


}

//tasks.named("bootJar") {
//    enabled = false
//}