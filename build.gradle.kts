import org.gradle.internal.os.OperatingSystem
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.6.20"

plugins {
    java
    kotlin("jvm") version("1.6.20")
}
group = "org.openrndr.examples"
version = "0.3.0"

val applicationMainClass = "TemplateProgramKt"
val applicationFullLogging = false

val openrndrUseSnapshot = false
val openrndrVersion = if (openrndrUseSnapshot) "0.5.1-SNAPSHOT" else "0.4.0-rc.7"

val openrndrOs = when (OperatingSystem.current()) {
    OperatingSystem.WINDOWS -> "windows"
    OperatingSystem.MAC_OS -> "macos"
    OperatingSystem.LINUX -> "linux-x64"
    else -> throw IllegalArgumentException("os not supported")
}

// supported features are: video, panel
val openrndrFeatures = setOf("video", "panel")


val orxUseSnapshot = false
val orxVersion = if (orxUseSnapshot) "0.5.1-SNAPSHOT" else "0.4.0-rc.8"

// supported features are: orx-camera, orx-compositor,orx-easing, orx-filter-extension,orx-file-watcher, orx-kinect-v1
// orx-integral-image, orx-interval-tree, orx-jumpflood,orx-kdtree, orx-mesh-generators,orx-midi, orx-no-clear,
// orx-noise, orx-obj, orx-olive

val orxFeatures = setOf(
    "orx-noise", "orx-midi", "orx-fx", "orx-compositor",
    "orx-panel", "orx-osc", "orx-shade-styles", "orx-image-fit", "orx-panel",
    "orx-gui", "orx-poisson-fill", "orx-jumpflood"
)

repositories {
    mavenCentral()
    if (openrndrUseSnapshot || orxUseSnapshot ) {
        mavenLocal()
    }
    maven(url = "https://maven.openrndr.org")
}

fun DependencyHandler.orx(module: String): Any {
    return "org.openrndr.extra:$module:$orxVersion"
}

fun DependencyHandler.openrndr(module: String): Any {
    return "org.openrndr:openrndr-$module:$openrndrVersion"
}

fun DependencyHandler.openrndrNatives(module: String): Any {
    return "org.openrndr:openrndr-$module-natives-$openrndrOs:$openrndrVersion"
}

fun DependencyHandler.orxNatives(module: String): Any {
    return "org.openrndr.extra:$module-natives-$openrndrOs:$orxVersion"
}

dependencies {
    runtime(openrndr("gl3"))
    runtime(openrndrNatives("gl3"))
    compile(openrndr("core"))
    compile(openrndr("svg"))
    compile(openrndr("animatable"))
    compile(openrndr("extensions"))
    compile(openrndr("filter"))

    compile("org.jetbrains.kotlinx", "kotlinx-coroutines-core","1.6.1")

    compile("io.github.microutils", "kotlin-logging","2.1.21")

    if (!applicationFullLogging) {
        runtime("org.slf4j","slf4j-nop","1.7.32")
    } else {
        runtime("org.apache.logging.log4j", "log4j-slf4j-impl", "2.17.2")
        runtime("com.fasterxml.jackson.core", "jackson-databind", "2.11.1")
        runtime("com.fasterxml.jackson.dataformat", "jackson-dataformat-yaml", "2.11.1")
    }

    if ("video" in openrndrFeatures) {
        compile(openrndr("ffmpeg"))
        runtime(openrndrNatives("ffmpeg"))
    }


    for (feature in orxFeatures) {
        compile(orx(feature))
    }

    if ("orx-olive" in orxFeatures) {
        compile("org.jetbrains.kotlin", "kotlin-scripting-compiler-embeddable")
    }

    if ("orx-kinect-v1" in orxFeatures) {
        runtime(orxNatives("orx-kinect-v1"))
    }

    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.13.2")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = applicationMainClass
    }
    doFirst {
        from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    }

    exclude(listOf("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA", "**/module-info*"))
    archiveFileName.set("application-$openrndrOs.jar")
}

tasks.create("zipDistribution", Zip::class.java) {
    archiveFileName.set("application-$openrndrOs.zip")
    from("./") {
        include("data/**")
    }
    from("$buildDir/libs/application-$openrndrOs.jar")
}.dependsOn(tasks.jar)

tasks.create("run", JavaExec::class.java) {
    main = applicationMainClass
    classpath = sourceSets.main.get().runtimeClasspath
}.dependsOn(tasks.build)