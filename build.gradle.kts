import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar
plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.palantir.docker") version "0.22.1"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "com.raghul"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
	testImplementation("io.projectreactor:reactor-test")
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



task<Copy>("unpack"){
	val bootJar = tasks.getByName<BootJar>("bootJar")
	dependsOn(bootJar)
	from(zipTree(bootJar.outputs.files.singleFile))
		.into("build/dependency")
}

docker{
	name = "expense-service"
	copySpec.from(tasks.getByName<Copy>("unpack").outputs).into("dependency")
	buildArgs(mapOf("DEPENDENCY" to "dependency"))
}