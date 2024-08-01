FROM openjdk:8
MAINTAINER mxx
COPY xiaoheihe-0.0.1-SNAPSHOT.jar /mxx_docker.jar
EXPOSE 8786
CMD ["--server.port=8786"]
ENTRYPOINT ["java","-jar","/mxx_docker.jar"]

