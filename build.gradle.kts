import magik.createGithubPublication
import magik.github

plugins {
    id("elect86.magik") version "0.1.4" apply false
}

version = "0.3.3+12"

tasks {
    withType<JavaCompile> {
        targetCompatibility = "1.8"
        sourceCompatibility = "1.8"
    }
}

subprojects {

    apply(plugin = "java-platform")
    apply(plugin = "maven-publish")
    apply(plugin = "elect86.magik")

//    extensions.configure<magik.MagikExtension> {
//        dryRun.set(true)
//        commitWithChanges.set(true)
//        verbose.set(true)
//    }

    group = "kotlin.graphics.platform"
    version = rootProject.version

    extensions.configure<PublishingExtension> {
        publications.createGithubPublication(addSnapshot = true) {
            if (this@subprojects.name == "source") {
                val lockfile = file("${this@subprojects.projectDir}/kxLockfile.txt")
                artifact(lockfile).classifier = "lockfile"
            }
            from(components["javaPlatform"])
            suppressPomMetadataWarningsFor("apiElements")
        }
        repositories {
            github {
                domain = "kotlin-graphics/mary"
            }
        }
    }
}