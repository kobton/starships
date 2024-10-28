# Get pricy spaceships

Spring boot application that get's the 10 most expensive starships from the https://swapi.dev/ Star Wars API. The application will call the Star Wars API and return a JSON of the most expensive starships with name, price and url.

### Run application

This is a Spring Boot application built with Maven and Java 17.

The application can be run with Maven using:

```
mvn clean install && mvn spring-boot run
```

The application can also be run with docker compose:

Build application:

```python
mvn clean install && mvn clean package
```

Run application with docker compose

```
docker compose up --build

docker compose kill -s SIGINT
```

### Sample request

```json
curl --request GET --url http://localhost:8080/api/starships
```

Response:

```json
[
	{
		"name": "Death Star",
		"price": "1000000000000",
		"url": "https://swapi.dev/api/starships/9/"
	},
	{
		"name": "Executor",
		"price": "1143350000",
		"url": "https://swapi.dev/api/starships/15/"
	},
	....
```
