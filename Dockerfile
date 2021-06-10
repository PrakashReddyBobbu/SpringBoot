FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD target/docker-demo-0.1.jar docker-demo-0.1.jar
ENTRYPOINT ["java","-jar","/docker-demo-0.1.jar"] 