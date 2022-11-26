apply(from = GradleDependencies.versionsGradle)

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("${GradleDependencies.android}${Versions.gradle}")
        classpath("${GradleDependencies.kotlin}${Versions.kotlin}")
        classpath("${GradleDependencies.android}${Versions.gradlePlugin}")
        classpath("${GradleDependencies.hilt}${Versions.hilt}")
    }
}

allprojects {

    repositories {
        google()
        mavenCentral()
    }

}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}