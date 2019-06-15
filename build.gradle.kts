plugins {
    java
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
            outputDir = file("ImageJ/plugins")
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    // You may activate any source repositories if needed
    // jcenter()
    // mavenCentral()

    flatDir {
        dirs("ImageJ/jars")
    }
}

dependencies {
    implementation(fileTree("ImageJ/jars/").matching {
        include("**/*.jar")
    })
    implementation(files("ImageJ/ij.jar"))
}

tasks.create<JavaExec>("run") {
    workingDir("ImageJ")
    main = "-jar"
    args = listOf(
            "-Xmx2048m",
            "ij.jar"
    )
}

