FROM openjdk:8-jre

MAINTAINER Sinda(sindazeng@gmail.com)

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /XHuiCloud-generator

WORKDIR /XHuiCloud-generator

EXPOSE 21000

ADD ./target/XHuiCloud-generator.jar ./

CMD sleep 90;java -Xms256m -Xmx512m -Djava.security.egd=file:/dev/./urandom -jar XHuiCloud-generator.jar
