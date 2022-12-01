plugins {
    kotlin("jvm") version "1.7.22"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.2")
}

tasks {
    sourceSets {
        main {
            java.srcDirs("src/main/kotlin")
        }
        test {
            java.srcDirs("src/test/kotlin")
        }
    }

    wrapper {
        gradleVersion = "7.6"
    }
}
