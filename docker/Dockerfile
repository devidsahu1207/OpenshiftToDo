FROM tomcat:8.0.20-jre8

MAINTAINER abhinish@prodevans.com

EXPOSE 8080

COPY ojdbc8.jar /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext

COPY Todos-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/todos.war