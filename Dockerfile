FROM gradle:jdk11

WORKDIR /server
COPY . /server
RUN ["./gradlew", "clean"]
RUN ["./gradlew", "-x", "test", "build"]
CMD ["gradlew", "bootRun"]
