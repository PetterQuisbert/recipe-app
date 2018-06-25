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
    