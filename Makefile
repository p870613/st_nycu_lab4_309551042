compile:
	./gradlew compileJava
	./gradlew processResources
	./gradlew classes

test:
	./gradlew compileTestJava
	./gradlew processTestResources
	./gradlew testClasses
	./gradlew test

assemble:
	./gradlew jar
	./gradlew assemble
