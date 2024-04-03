import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
	kotlin("kapt") version "1.6.21"
	idea
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

noArg {
	annotation("javax.persistence.Entity")
}

group = "com.yhmane"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}


configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

dependencies {
	// spring
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")

	// jpa & h2
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.h2database:h2")
	implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.8.1")
	// QueryDSL
	implementation("com.querydsl:querydsl-jpa:5.0.0")
	implementation("com.querydsl:querydsl-apt:5.0.0")
	implementation("javax.annotation:javax.annotation-api:1.3.2")
	implementation("javax.persistence:javax.persistence-api:2.2")
	annotationProcessor(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
	kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

	// log
	implementation("io.github.microutils:kotlin-logging:2.1.23")

	// kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// gson
	implementation("com.google.code.gson:gson:2.9.1")
	implementation("commons-io:commons-io:2.11.0")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.mockk:mockk:1.12.4")
	testImplementation("com.ninja-squad:springmockk:3.1.1")

	// testcontainers
	testImplementation("org.testcontainers:testcontainers:1.17.3")
	testImplementation("org.testcontainers:mysql:1.17.3")
	implementation("mysql:mysql-connector-java")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// Kotlin QClass Setting
kotlin.sourceSets.main {
	println("kotlin sourceSets builDir:: $buildDir")
	setBuildDir("$buildDir")
}

idea {
	module { val kaptMain = file("build/generated/source/kapt/main")
		sourceDirs.add(kaptMain)
		generatedSourceDirs.add(kaptMain)
	}
}
