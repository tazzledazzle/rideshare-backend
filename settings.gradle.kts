// # settings.gradle.kts
pluginManagement {
    repositories { 
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "rideshare-backend"

include("common", "matching-engine-java", "api-kotlin")
