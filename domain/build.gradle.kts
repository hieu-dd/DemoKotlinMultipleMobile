import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

version = "1.0"

kotlin {
    android()
    ios()
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

    val ktor_version = "2.0.0"

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktor_version")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation( "io.ktor:ktor-client-okhttp:$ktor_version")
            }
        }
        val androidTest by getting
        val iosMain by getting {
            dependencies {
                implementation( "io.ktor:ktor-client-ios:$ktor_version")
            }
        }
        val iosTest by getting

        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Test by getting {
            dependsOn(iosTest)
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