Simple REST message board with Spring 4
---------------------------------------------

This is a test REST service application implemented using Spring 4 and Spring WebMVC for a work related assignment.

The technologies were chosen mainly as an opportunity to try new Spring WebMVC features. Note that there is no XML configuration.

The application is in a flat structure of a single maven module. Application layers are divided by the package structure 
(rest, service, domain, repository). The repository layer is implemented with a synchronized ArrayList. The application layers
are integrated using interfaces and dependency injection, so the repository implementation could be changed without changes to other layers.

The application exposes REST resources and supports JSON or XML responses for a GET request to /messages. New messages 
can be POSTed to /messages as JSON.

The caller must specify the API version as an Accept header in the request as follows:

- Version 1 JSON: application/vnd.simplemsgboard.v1+json
- Version 2 JSON: application/vnd.simplemsgboard.v2+json
- Version 2 XML: application/vnd.simplemsgboard.v2+xml

The difference with versions 1 and 2 is that the message in version 2 contains a URL. Otherwise the message formats are the same 
containing title, content and sender.

Some unit tests are included but more could be added. Integration tests with e.g. embedded jetty and sending requests
with a java REST client could also be added for completeness.

Error responses could be improved to contain validation error messages. Currently only the HTTP status code indicates an error. No further 
error details are returned to the caller.

Building and running
-------------------

- Build: mvn clean install
- Run: mvn jetty:run
- Run with something else than jetty: Build and deploy the war file from target folder.

Sample usage
------------

List messages with version 1 format: curl http://localhost:8080/messages -H "Accept: application/vnd.simplemsgboard.v1+json" 

List message v2: curl http://localhost:8080/messages  -H "Accept: application/vnd.simplemsgboard.v2+json" 

List message v2 XML: curl http://localhost:8080/messages -H "Accept: application/vnd.simplemsgboard.v2+xml"

Add message (only v2 supported): curl http://localhost:8080/messages -X POST -H 'Content-type: application/vnd.simplemsgboard.v2+json' -H 'Accept: application/vnd.simplemsgboard-v2+json' -d '{"title":"title","content":"content!!1","sender":"Sender","url":"http://www.nitorcreations.com"}'

(Add -v to see header behavior: No Content when there are no messages, Bad Request when there are validation errors)