import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.8.0"
  id("org.jetbrains.dokka") version "1.7.20"
  `java-library`
  `maven-publish`
}

group = "org.veupathdb.lib.s3"
version = "0.8.0+s34k-0.9.0"

repositories {
  mavenLocal()
  mavenCentral()

  maven {
    name = "GitHubPackages"
    url  = uri("https://maven.pkg.github.com/veupathdb/packages")
    credentials {
      username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
      password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
    }
  }
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8

  withSourcesJar()
  withJavadocJar()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("org.slf4j:slf4j-api:1.7.36")

  api("org.veupathdb.lib.s3:s34k:0.9.0")

  testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
  testImplementation(kotlin("test"))
}

tasks.test {
  useJUnitPlatform()
}

task("docs") {
  dependsOn("dokkaHtml", "dokkaJavadoc")
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}


publishing {
  repositories {
    maven {
      name = "GitHub"
      url = uri("https://maven.pkg.github.com/VEuPathDB/lib-s34k-core")
      credentials {
        username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
      }
    }
  }

  publications {
    create<MavenPublication>("gpr") {
      from(components["java"])
      pom {
        name.set("Generalized S3 API")
        description.set("Provides a set of basic implementations and abstract types implementing base functionality of the S34K API.")
        url.set("https://github.com/VEuPathDB/lib-s34k-core")
        developers {
          developer {
            id.set("epharper")
            name.set("Elizabeth Paige Harper")
            email.set("epharper@upenn.edu")
            url.set("https://github.com/foxcapades")
            organization.set("VEuPathDB")
          }
        }
        scm {
          connection.set("scm:git:git://github.com/VEuPathDB/lib-s34k-core.git")
          developerConnection.set("scm:git:ssh://github.com/VEuPathDB/lib-s34k-core.git")
          url.set("https://github.com/VEuPathDB/lib-s34k-core")
        }
      }
    }
  }
}
