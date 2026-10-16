plugins {
    base
    `java-library`
}

group = "com.viaversion"
version = "1.0.0"

repositories {
    maven("https://repo.viaversion.com")
    maven("https://repo.papermc.io/repository/maven-public/")
    mavenCentral()
}

dependencies {
    compileOnly(project(":pslistener")) // This should not be included in the final jar
    compileOnly("com.viaversion:viaversion-bukkit:5.12.0")
    compileOnly("com.viaversion:viaversion-api:5.12.0")
    compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
