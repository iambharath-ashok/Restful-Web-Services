# Spring RESTFul Services

### 1. What is WebService?
###Service Delivered over Internet or HTTP.

### W3 Definitaion of Web Services
### S/w Sytem Designed(SSD) to provide machine to machine interaction over internet.

### 3 Keys od WebServices
1. Machine to Machine(application to application) interaction.
2. Interoperable - Platform Independent.
3. Communication Over N/W.


## How data exchange take place?
1 Data Exchange take place through request and response.
2 Request and Resp should be platform independent.
3 Two Poplular Formats are 
	* XMl - Xtensible Markup Language 
	* JSON - Java Script Object Notation
4. Servce Definition
	Service Definition Describes
		* What is the Request/Response Format (XML/JSON)
		* What is the  Request/Resp Structure
		* What is the End point to send the request
		


## Key Terminologies
Service Provider - Is the one who provides the Service or Server
Service Consumer - Is the one who consumes the service or client
Transport - Defines how Service is Called
	HTTP/Internet or MQ
		
-------------------------
## Types of WebServices
1. SOAP Based 
	SOAP imposes restictions on req and res
	SOAP - Simple Object Acces Protocol
	SOAP uses XML as req/res formats
	SOAP defines specific stucture on req/res
	SOAP REQ/RESP format
		SOAP:ENVELOP
		SOAP:HEADER
		SOAP:BODY
		* SOAP HEADER is Optional
	
		SOAP
	FORMAT (DATE EXCHANGE FORMAT)
		* XML
	TRANSPORT
		* HTTP
		* MQ
	Service Definition
		WSDL
	
	WSDL
		WebService Definition Langauage	
		WSDL defines the endpoint where service is exposed at.
		WSDL defines all the operations that are allowed
			Opertaions 
				Get 
				Delete
				Create
		WSDL defines the Req/Res Structure
		
		
	
2. REST Styled
	
	REpresentational State Transfer
	REST make best use of HTTP
	REST is built on top of HTTP
	REST is Architectural Style
	
	HTTP
	In REST REQ/RESP formats are defined by HTTP
	REQ/RESP have Header and Body
	HTTP defines methods like GET,POST,DELETE,PUT etc...
	HTTP methods defines what ACTION we are doing
	
	
	REST is Full of resources
	Every thing is resource
	
	In REST resource can have any format or representation
	XML, JSON, HTML
	
	
		REST
	FORMAT (DATE EXCHANGE FORMAT)
		No restriction on the format
		JSON is popular
	TRANSPORT
		HTTP
	SERVICE DEFINITION
		WADL 
		SWAGGER
	
--------------------------	

## REST vs SOAP                              

|------------------------------------------------------------------------------|
|				REST                      | 		SOAP                       |
|------------------------------------------------------------------------------|
|	FORMAT (DATE EXCHANGE FORMAT)		  | FORMAT (DATE EXCHANGE FORMAT)      |
|		No restriction on the format	  | 	XML                            |
|		XML, JSON, HTML					  |                                    |
|		JSON is popular                   |                                    |
|	TRANSPORT                             | TRANSPORT                          |
|		HTTP                              |		HTTP, MQ                       |
|	SERVICE DEFINITION                    | SERVICE DEFINITION                 |
|		WADL                              |  WSDL                              |
|		SWAGGER                           |                                    |
|	                                      |                                    |
|------------------------------------------------------------------------------|
										  
										  
=================================================================================										  

## Spring Auto Configure and Dispatcher Servlet

	- Spring Boot will auto configure most of the beans that are on the classpath
	- Spring Boot will provide the implementation for Dispatcher Servlet
	- Spring Boot will automically provide the implementation for all the beans present in the jars that are present in the classpath

##  Dispatcher Servlet
	- Dispatcher servlet is a front controller
	- Dispatcher Servlet folows the front controller Pattern
	- Dispatcher Servlet will be mapped to '/' (root of the app)
	- Dispatcher servlet handles all the incoming requests
	
	- Dispatcher Servlet knows all the mappings in the app
	- It knows the mapping of url with method 
	- Based on the url it will execute the method
	
	
## Responding with Proper Response Code and  Location of resource created

### ResponseEntity
	- ResponseEntity Class is related to HTTP Status codes
	- ResponseEntity is used to send the proper HTTP response code
	- ResponseEntity is having methods corresponding to HTTP code
	
### ServletUriComponentsBuilder
	- ServletUrComponentBuilder is used to create a URI 
	- ServletUriComponentsBuilder is have access to Request, Context, RequestPath etc...

=================================================================================='
# Implementing Exception Handling and 404 Resource not found

- Implement a custom exception 
- Use @ResponseStatus annotation with applicable value
- Ex: @ResponseStatus(HttpStatus.NOT_FOUND)	
- Ex:
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class UserNotException extends RuntimeException

# Implementing Generic Exception for whole application

- ResponseEntityExceptionHandler is spring realted class
- ResponseEntityExceptionHandler is specialization of component for classes
- ResponseEntityExceptionHandler class is a special type of component that allows to use  the common methods thats needs to be shared across multiple controllers, components(classes).
- ResponseEntityExceptionHandler is class abstract clalss has provided implementation for non abstarct methods.

## How to Implement Generic Exception
	- Define a class that extends ResponseEntityExceptionHandler class
	- Add the @RestController on top of class, as this class sends the response back
	- Add the @ControllerAdvice on top of class, this will make applicable for for all the controllers
	- Define the method and add the @ExceptionHandler annotation on top of method
	- @ExceptionHandler will take  the type of class as argument that needs to handled
	- Ex:
	
	@ControllerAdvice
		@RestController
		public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
		
			@ExceptionHandler(Exception.class)
			public final ResponseEnity<Object> handleAllExceptions () {
				ExceptionResponse exceptionResponse = new ExceptionResponse();
				return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
