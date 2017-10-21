FROM gradle:jdk8
LABEL maintainer="message2prateek@gmail.com"
WORKDIR /jenkinsTest
ENTRYPOINT ./gradlew
CMD ["runUnitTests"]
