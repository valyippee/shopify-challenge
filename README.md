# shopify-backend-developer-challenge

This is an inventory tracking web application for a logistics company. 
It provides basic CRUD functionalities on inventory items, which are called [`Product`](https://github.com/valyippee/shopify-challenge/blob/main/src/main/java/entity/Product.java)
entities in this application.
The additional feature implemented was the ability to create [`Shipment`](https://github.com/valyippee/shopify-challenge/blob/main/src/main/java/entity/Shipment.java) 
and assign an amount of `Product` to it specified by the user through the website. The inventory will then be adjusted appropriately. 

## Table of Contents
- Install and Run
- Things to Note
- Bugs/ Issues

## Install and Run 
The technologies used are Java for the backend (with no frameworks), React for the frontend website, and Gradle for building the application.

To run this application, clone this repository and navigate to the root of the project. 

There are two ways to start the backend server. 

### Firstly, from the command line:
In the command line, use Gradle wrapper to build the application:
```
./gradlew build 
```

A jar file will be created at the relative path `\build\libs`

Run 
```
cd build\libs
``` 
to enter that directory, and 
```
java -jar .\shopify-challenge-1.0-SNAPSHOT-all.jar
``` 
to start the backend server.



### Alternatively, you can run it in an IDE:

Start up the backend server by running the main class in ```src\main\java\launcher\Main.java```

### Next, start the frontend:
In the command line, change directory to the frontend folder using  
```
cd src\main\frontend
``` 
and then, run 

```
npm start
```


## Things to Note

shipment status - see issue

executable jar built but react does not start - future implementation would be to deploy them tgt

frontend was imported from elsewhere - I did not write all the code
