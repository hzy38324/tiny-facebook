# tiny-facebook
A tiny facebook built on Spring Boot.

## Introduction
This is a tiny facebook built on Spring Boot.   
I will show you how to develop a web application step by step, using Spring Boot、Spring Data、Spring Security、Redis、Spring Cloud and so on.

## Tag
I will create a tag for every step of this application.   
For example, if you want to know how to provide RESTful service by using Spring Boot, just do this command on your git bash:
```
git checkout v2.0
```
You can go to the [Release Page](https://github.com/hzy38324/tiny-facebook/releases) to see the tag info.

## Run
Before running the application, make sure you have JDK1.8+ and Gradle4.1+ in your environment.  
Do this command to install gradlew: 
```
gradle wrapper --gradle-version 2.13
```
And then do this command to start the application:
```
gradlew clean && gradlew build && java -jar build/libs/tiny-facebook-0.1.0.jar
```

# Documentaion
I wrote blogs in Chinese to explain the code, just jump for it - > [Tiny Facebook Documentaion](http://bridgeforyou.cn/2017/10/21/Spring-Novel-4-Build-RESTful-Service-with-Spring-Boot/)