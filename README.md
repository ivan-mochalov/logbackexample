# Logback example
The project included a small example of using logback and aspectj.
Check this out:
- put your own 'log_home' to the logback.xml or use default one
- go to 'example-meta' package
- run 'mvn clean install -f pom.xml tomcat7:run'
- call '$ curl -X POST http://localhost:9090/api/logger/console/TRACE'
- check your logs ;)

