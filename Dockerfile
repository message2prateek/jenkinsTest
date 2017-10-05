FROM openjdk:8
LABEL maintainer="message2prateek@gmail.com"
 RUN wget https://services.gradle.org/distributions/gradle-4.2-bin.zip &&\
 	mkdir /opt/gradle &&\
 	unzip -d /opt/gradle gradle-4.2-bin.zip &&\
	export PATH=$PATH:/opt/gradle/gradle-4.2/bin
COPY $PWD /home/master/Documents/Padhai/jenkinsTest
WORKDIR /home/master/Documents/Padhai/jenkinsTest
RUN chmod +x gradlew 
ENTRYPOINT ["./gradlew"]
CMD ["test"]
