plugins {
    id("java")
}

group = "me.iwareq"
version = "1.1.7-PM1E"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("lib/patched.jar"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<JavaCompile> {
    options.encoding = Charsets.UTF_8.name()
}

tasks.withType<ProcessResources> {
    filteringCharset = Charsets.UTF_8.name()
    filesMatching("plugin.yml") {
        expand("version" to version)
    }
}
