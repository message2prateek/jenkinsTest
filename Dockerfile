FROM openjdk:8
LABEL maintainer="message2prateek@gmail.com"
RUN wget https://services.gradle.org/distributions/gradle-4.2-bin.zip
RUN mkdir /opt/gradle
RUN unzip -d /opt/gradle gradle-4.2-bin.zip
RUN export PATH=$PATH:/opt/gradle/gradle-4.2/bin
COPY $PWD /usr/jenkinsTest
WORKDIR /usr/jenkinsTest
ENTRYPOINT ["./gradlew"]
CMD ["test"]
