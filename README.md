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

You will have to run the frontend and backend seperately. By default, the frontend runs on port 3000 and the backend runs on port 4567.

### To run the backend:

#### Windows command prompt

Use Gradle wrapper to build the application using the command

```
.\gradlew build
```

The build could fail. See [this issue](https://github.com/valyippee/shopify-challenge/issues/6) and follow the steps to resolve the error.

After that, run the `.\gradlew build` command again to finish the build.

A jar file will be created at the relative path `\build\libs`

Run 
```
cd build\libs
``` 
and 
```
java -jar .\shopify-challenge-1.0-SNAPSHOT-all.jar
``` 
to start the backend server.

#### IDE
Navigate and run the main class at `src/main/java/launcher/Main.java`.

### To run the frontend:

#### Windows command prompt

Change directory to the frontend folder using  
```
cd src\main\frontend
``` 
and run 

```
npm start
```


## Things to Note

shipment status - see issue

executable jar built but react does not start - future implementation would be to deploy them tgt

frontend was imported from elsewhere - I did not write all the code
