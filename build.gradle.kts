buildscript {
  repositories {
    mavenCentral()
    gradlePluginPortal()
    jcenter()
  }

  extra.apply {
    set("kotlinVersion", "1.4.21")
    set("kotestVersion", "4.3.0")
    set("mockkVersion", "1.10.5")
  }
}

repositories {
  mavenCentral()
}

plugins {
  kotlin("jvm") version "1.4.21"
  id("io.kotest") version "0.2.6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val javaVersion = JavaVersion.VERSION_14

tasks.withType<Test> {
  useJUnitPlatform()
}

dependencies {
  implementation(kotlin("stdlib"))
  testImplementation("io.mockk:mockk:${rootProject.extra["mockkVersion"]}")
  testImplementation("io.kotest:kotest-extensions-spring:${rootProject.extra["kotestVersion"]}")
  testImplementation("io.kotest:kotest-framework-engine-jvm:${rootProject.extra["kotestVersion"]}")
  testImplementation("io.kotest:kotest-property-jvm:${rootProject.extra["kotestVersion"]}")
  testImplementation("io.kotest:kotest-runner-junit5-jvm:${rootProject.extra["kotestVersion"]}")
}
