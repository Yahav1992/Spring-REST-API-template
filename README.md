# Spring-REST-API-template
A java spring REST API template for a quick start

## Endpoints
Returns a response based on endpoint:
1) `/api/sampleString/` - generic string.
2) `/api/appProp/` - string created from application.properties.
3) `/api/users/` - some H2 DB sample users created
4) `get users by id`, `create new users`, `delete users by id`

## Dependencies
pom.xml dependencies includes:
1) `actuator` - some free endpoints for system description
2) `security` - protection to endpoints, user & password required
3) `devtools` - hot-load when saving changes, no restart required - some additional configuration needed in intellij *
4) `lombok` - automatically creating constructors, getters, setters, toString for a class - some additional configuration needed in intellij *
5) `Atlas mongodb` - using cloud mongodb to store users and courses data.

## Installations, Troubleshooting & Resources 

###### intellij changes required for supporting devtools:
* settings -> build, execution, deployment -> compiler -> tick the "build project automatically" and apply.
* Ctrl+ Shift+A -> Registry and Enable compiler.automake.allow.when.app.running

###### intellij changes required for supporting lombok:
* add lombok plugin
* [Enable annotation processing](https://www.jetbrains.com/help/idea/annotation-processors-support.html#e77a66d8)

###### Resources
* [Enabling CORS](https://spring.io/guides/gs/rest-service-cors/#global-cors-configuration)
* [Exception Handling in Spring MVC](https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
