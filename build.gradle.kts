plugins {
	java
	id("org.springframework.boot") version "2.7.11"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

val springKafkaVersion = "2.9.2"
var citrusVersion = "3.3.0"
var cucumberVersion = "7.3.1"

dependencies {
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-test")

	// spring
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// citrus
	testImplementation("com.consol.citrus:citrus-base:${citrusVersion}")
	testImplementation("com.consol.citrus:citrus-endpoint-catalog:${citrusVersion}")
	testImplementation("com.consol.citrus:citrus-spring:${citrusVersion}")
	testImplementation("com.consol.citrus:citrus-testng:${citrusVersion}")
	testImplementation("com.consol.citrus:citrus-cucumber:${citrusVersion}")

	testImplementation("org.testng:testng:7.6.0")

	// cucumber
	testImplementation("io.cucumber:cucumber-testng:${cucumberVersion}")
	testImplementation("io.cucumber:cucumber-spring:${cucumberVersion}")
	testImplementation("io.cucumber:cucumber-java:${cucumberVersion}")

}

tasks.withType<Test> {
	useTestNG()
	setScanForTestClasses(false)
}

