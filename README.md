# boot

* [Exception Handler](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/exception/CustomizedResponseEntityExceptionHandler.java)
* [Swagger Configuration](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/SwaggerConfig.java)
* [Localization using 'Accept' header](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java#L22)
* [Resource bundles for internationalization](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java#L33)
* Dynamic and static filtering on fields in json
  * [Controller](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/filtering/FilteringController.java#L18)
  * [Bean](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/filtering/SomeBean.java#L7)

Links of interests
* [Hal Browser](http://localhost:8080)
```
<dependency>
  <groupId>org.springframework.data</groupId>
  <artifactId>spring-data-rest-hal-browser</artifactId>
  <version>3.0.6.RELEASE</version>
</dependency>
```
* [Actuator](http://localhost:8080/actuator)
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
  <version>2.0.0.RELEASE</version>
</dependency>
 ```
* [Swagger](http://localhost:8080/v2/api-docs)
* [Swagger UI](http://localhost:8080/swagger-ui.html)
```
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger2</artifactId>
  <version>2.8.0</version>
</dependency>
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger-ui</artifactId>
  <version>2.8.0</version>
</dependency>
```
* [H2 Console](http://localhost:8080/h2-console)
  * Ensure 'spring.h2.console.enabled=true' is set in application.properties
