FROM openjdk:8-jdk-alpine as build
WORKDIR /workspace/app

# copy gradle files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
RUN ./gradlew dependencies

# copy full solution and build
COPY . .
RUN ./gradlew build
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)

FROM openjdk:8-jre-slim

RUN mkdir /app

#copy over the application JAR
COPY --from=build /workspace/app/build/libs/*.jar /app/spring-boot-application.jar

#setup the entry-point to run the application on startup
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

