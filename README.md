# boot

* [Exception Handler](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/exception/CustomizedResponseEntityExceptionHandler.java)
* [Swagger Configuration](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/SwaggerConfig.java)
* [Localization using 'Accept' header](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java#L22)
* [Resource bundles for internationalization](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java#L33)
* Dynamic and static filtering on fields in json
  * [Controller](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/filtering/FilteringController.java#L18)
  * [Bean](https://github.com/idaho-guy/boot/blob/master/restful-web-services/src/main/java/com/in28minutes/rest/webservices/restfulwebservices/filtering/SomeBean.java#L7)
* Spring cloud config server
  * [@EnableConfigServer](https://github.com/idaho-guy/boot/blob/master/spring-cloud-config-server/src/main/java/com/in28minutes/microservices/springcloudconfigserver/SpringCloudConfigServerApplication.java#L8)
  * [Configure url to git repo:spring.cloud.config.server.git.uri](https://github.com/idaho-guy/boot/blob/master/spring-cloud-config-server/src/main/resources/application.properties#L4)
  * Naming convention in repo [app name].[environment].[properties]; for app limits-service,property file names would be
    * limits-service-dev.properties
    * limits-service-stage.properties
    * limits-service-prod.properties
    * limits-service.properties (default)
  * Above properties would be accessed with:
    * http://localhost:8888/limits-service/dev
    * http://localhost:8888/limits-service/stage
    * http://localhost:8888/limits-service/prod
    * http://localhost:8888/limits-service/default
* Spring cloud client
  * Need to rename 'application.properties' to bootstrap.properties
  * The name used for the 'spring.application.name' will be used for the [app name] described above
    

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
  * Default jdbc url is 'jdbc:h2:mem:testdb'
```
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>runtime</scope>
</dependency>
```
* Feign Client
  * [@FeignClient](https://github.com/idaho-guy/boot/blob/master/currency-conversion-service/src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyExchangeProxy.java#L8)
  * [@EnableFeignClients](https://github.com/idaho-guy/boot/blob/master/currency-conversion-service/src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyConversionServiceApplication.java#L11)
```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

```
