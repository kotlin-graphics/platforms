plugins {
    id("my-platform")
}

// allow the definition of dependencies to other platforms like the JUnit 5 BOM
//javaPlatform.allowDependencies()

dependencies {
    //    api(platform("org.junit:junit-bom:5.7.0"))
    constraints {
        api("io.kotest:kotest-runner-junit5:5.5.2")
        api("io.kotest:kotest-assertions-core:5.5.2")
    }
}
