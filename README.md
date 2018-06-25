# TRUEXTEND

## RECIPE

Requirements:
    - Java8+
    - Maven 3.5.3+
    - Docker 18.03.1-ce-mac65 (24312)

## Development server

To Run the app, perform:

    - docker-compose up -d 
    (Wait until mysql complete loading and create a schema "recipeapp")
    - mvn spring-boot:run
   
To run tests and  get a jar to deploy perform:

    - mvn clean package
    (the reciipe-app-0.0.1-SNAPSHOT.jar file is in the target folder)

## Run end points
It was created 2 users by default:  

    username: petter
    password: p
    role: ROLE_USER
    
    username: admin
    password: p
    role: ROLE_ADMIN
 
 To run endpoints from terminal perform:
    - curl localhost:8080/api/v1/recipes
    This should get a 401 error
    
    - curl -u petter localhost:8080/api/v1/recipes
    or
    - curl -u admin localhost:8080/api/v1/recipes
    
    To get proper results.
    