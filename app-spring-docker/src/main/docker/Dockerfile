FROM java:8
 
MAINTAINER fabgue
 
ADD app-spring-docker.jar /app.jar
 
EXPOSE 8000 8080
 
CMD java -Djava.security.egd=file:/dev/./urandom -jar -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n /app.jar