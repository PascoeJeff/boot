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
Ribbon load balancing
* [@RibbonClient](https://github.com/idaho-guy/boot/blob/master/currency-conversion-service/src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyExchangeProxy.java#L11)
* Set [currency-exchange-service.ribbon.listOfServers](https://github.com/idaho-guy/boot/blob/master/currency-conversion-service/src/main/resources/application.properties#L3) property in application.properties
* Cleaner to use Eureka and then listOfServers will not need to be specified; Ribbon will use the name to look up registered servers in Eureka
```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
```
Eureka Server
* [@EnableEurekaServer](https://github.com/idaho-guy/boot/blob/master/netflix-eureka-naming-server/src/main/java/com/in28minutes/microservices/netflixeurekanamingserver/NetflixEurekaNamingServerApplication.java#L8)
* Configuration in [application.properties](https://github.com/idaho-guy/boot/blob/master/netflix-eureka-naming-server/src/main/resources/application.properties#L3)
* [Console](http://localhost:8761/)
```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
Eureka Client
* [@EnableEurekaClient](https://github.com/idaho-guy/boot/blob/master/currency-conversion-service/src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyConversionServiceApplication.java#L10)
* application.properties entry: eureka.client.service-url.default-zone=http://localhost:8761/eureka
```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
Zuul API Gateway
* API Gateways
  * Authentication, authorization, and security
  * Rate limits
  * Fault tolerance
  * Service aggregation
* Access microservices through api gateway instead of directly
* [@EnableZuulProxy and @EnableDiscoveryClient](https://github.com/idaho-guy/boot/blob/master/netflix-zuul-api-gateway-server/src/main/java/com/in28minutes/microservices/netflixzuulapigatewayserver/NetflixZuulApiGatewayServerApplication.java#L8)
* Other applications registered with Eureka can be access through zuul port (8765)
* Format is http://localhost:8765/{service name}/{uri}
```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>
```
Sleuth (distributed tracing)
```
<dependency>
  	<groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
```

