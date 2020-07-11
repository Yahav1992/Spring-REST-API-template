# Spring-REST-API-template
A java spring REST API template for a quick start

Returns a response based on endpoint:
1) "/api/sampleString/" - generic string.
2) "/api/appProp/" - string created from application.properties.
3) "/api/h2Entities/" - some H2 DB sample entities created
4) get by id, post, delete by id

pom.xml dependencies includes:
1) actuator (some free endpoints for system description)
2) security (protection to endpoints, user & password required)
3) devtools (hot-load when changes are saved, no restart required - some additional configuration needed in intellij *)
4) lombok (automatically creating constructors, getters, setters, toString for a class - some additional configuration needed in intellij *)
5) In memory db - H2

_________________________________________________________
* intellij changes required for supporting devtools:
1) settings -> build, execution, deployment -> compiler -> tick the "build project automatically" and apply.
2) Ctrl+ Shift+A -> Registry and Enable compiler.automake.allow.when.app.running

* intellij changes required for supporting lombok:
1) add lombok plugin
2) Enable annotation processing (https://www.jetbrains.com/help/idea/annotation-processors-support.html#e77a66d8)
