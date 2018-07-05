FROM openjdk:8
LABEL maintainer="message2prateek@gmail.com"
COPY "./webapp/build/libs/loginWebApp-1.0.0.war" /home/
WORKDIR /home
EXPOSE 8081
ENTRYPOINT ["java"]
CMD ["-jar", "loginWebApp-1.0.0.war"]
