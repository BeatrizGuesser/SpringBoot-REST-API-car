# Challenge-week-4-car
 Is a Java-based application that provides two endpoints, one for GET a car and one for POST a car.
# Built with
Java 11, Maven and MySQL. The connection to the database was made using JPA and JDBC.
# Endpoint POST
To register a car in the database, send a POST request to the /cars/post. You can use Postman and the request payload is: 

{

"idChassi": 123, (type:long(this should be the primary key of your table andunique)

"name": "New fiesta", (type:String)

"brand" : "Ford" ,(type:String, must accept only Ford, Chevrolet, BMW, Volvo)

"color": "blue", (type:String)

"fabricationYear": "2014/2015" (type:String)

}
# Endpoint GET
To retrieve a car from the database, send a GET request to the /cars/get/{idChassi} endpoint, replacing {idChassi} with the actual idChassi value.
# Rules
1- The name of the database is "db_car";

2- The username is "root" and the password is "root";

3- The “brand” field accept only the brands Ford,Chevrolet,BMW and Volvo. If any other brand is sent, will trigger an exception and the request will not be successful;

4- When a GET is called, the correct idChassi must be passed and the corresponding car saved by the POST in the database will be returned. A incorrect idChassi will trigger an exception;

5- Nulls are not saved in the database or returned in the OUTPUT or ENTRY DTOs. If a field is null, will trigger an exception.
