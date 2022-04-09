import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../ios/Podfile")
        framework {
            baseName = "domain"
        }
    }

    val xcf = XCFramework("domain")
    ios {
        binaries {
            framework {
                baseName = "domain"
                xcf.add(this)
            }
        }
        // By default gradle plugin adds bitcode on iOS target:
        // - For debug build it embeds placeholder LLVM IR data as a marker.
        // - For release build it embeds bitcode as data.

        // Objective-C generics support by default
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by getting {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}

// Build ios framework
tasks.register<Zip>("packageDomainReleaseXCFramework") {
    archiveFileName.set("Domain.zip")
    destinationDirectory.set(buildDir.resolve("outputs/xcframework"))

    from(buildDir.resolve("XCFrameworks/release"))
}

afterEvaluate {
    tasks.getByName("assemble")
        .dependsOn("assembleDomainXCFramework")

    tasks.getByName("assembleRelease")
        .dependsOn("assembleDomainReleaseXCFramework")
        .finalizedBy("packageDomainReleaseXCFramework")
}