# Spring-REST-API-template
A java spring REST API template for a quick start

A simple rest controller returns a string created from application.properties.

pom.xml dependencies includes:

actuator (some free endpoints for system description)

security (protection to endpoints, user & password required)

devtools (hot-load when changes are saved, no restart required - some additional configuration needed in intellij *)





* intellij changes required for supporting devtools:
1) settings -> build, execution, deployment -> compiler -> tick the "build project automatically" and apply.
2) Ctrl+ Shift+A -> Registry and Enable compiler.automake.allow.when.app.running
