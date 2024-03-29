import magik.createGithubPublication
import magik.github
import org.gradle.kotlin.dsl.`java-platform`
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    id("elect86.magik")
    `java-platform`
    `maven-publish`
}

version = rootProject.version
group = rootProject.group

publishing {
    publications.createGithubPublication {
        artifactId = "platform-$artifactId"
        from(components["javaPlatform"])
        suppressPomMetadataWarningsFor("apiElements")
    }
    repositories {
        github {
            domain = "kotlin-graphics/mary"
        }
    }
}