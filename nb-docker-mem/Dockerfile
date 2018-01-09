FROM openjdk:8
ADD target/docker-mem.jar /usr/src/myapp/
WORKDIR /usr/src/myapp
EXPOSE 8080
CMD java -XX:+PrintFlagsFinal -XX:+PrintGCDetails -jar docker-mem.jar
