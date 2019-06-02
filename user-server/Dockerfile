FROM hub.c.163.com/library/java:8-alpine

MAINTAINER sheriff 471197297@qq.com

ADD target/*.jar  user-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/user-service.jar"]