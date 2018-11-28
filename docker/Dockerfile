FROM tomcat:8.0.20-jre8

MAINTAINER abhinish@prodevans.com

EXPOSE 8080

RUN mkdir  /jar

COPY ojdbc8.jar /jar

COPY Todos-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/todos.war