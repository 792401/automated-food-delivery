plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.microsoft.playwright:playwright:1.40.0")
}


// Usage: ./gradlew playwright --args="help"
tasks.register<JavaExec>("playwright") {
    classpath(sourceSets["test"].runtimeClasspath)
    mainClass.set("com.microsoft.playwright.CLI")
}


tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}