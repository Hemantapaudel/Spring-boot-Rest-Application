SPRING BOOT REST APPLICATION

AccountController : expose rest end point,
SecurityConfiguration : Basic Authentication implementation,
CustomBasicAuthenticationEntryPoint : handle the unauthorized request,
RestConsumer : Rest API consuming example with base authentication,

Application Uri: http://localhost:8081/restapi/getaccount?account=123456


# What is REST and RESTful web services ?
REST stands for REpresentational State Transfer (REST) its a relatively new concept of writing web services which enforces a stateless client server design where web services are treated as resource and can be accessed and identified by there URL unlike SOAP web services which were defined by WSDL.

Web services written by apply REST Architectural concept are called RESTful web services which focus on System resources and how state of Resource should be transferred over http protocol to a different clients written in different languages. In RESTful web services http methods like GET, PUT, POST and DELETE can can be used to perform CRUD operations.

# What is differences between RESTful web services and SOAP web services ?
Though both RESTful web series and SOAP web service can operate cross platform they are architecturally different to each other, here is some of differences between REST and SOAP:
1) REST is more simple and easy to use than SOAP
2) REST uses HTTP protocol for producing or consuming web services while SOAP uses XML.
3) REST is lightweight as compared to SOAP and preferred choice in mobile devices and PDA's.
4) REST supports different format like text, JSON and XML while SOAP only support XML.
5) REST web services call can be cached to improve performance.

# Which HTTP methods are supported by RestFull web services ?
Another common REST interview questioning RESTFul web service each Resource supports GET, POST, PUT and DELETE http methods.GET is mapped to represent(), POST - acceptRepresentation(), PUT- storeRepresentation and DELET for rmeoveRepresentation.

# What happens if RestFull resources are accessed by multiple clients ? do you need to make it thread-safe?
Since a new Resource instance is created for every incoming Request there is no need to make it thread-safe or add synchronization. multiple client can safely access RestFull resources concurrently.









