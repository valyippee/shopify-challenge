# shopify-backend-developer-challenge

This is an inventory tracking web application for a logistics company. 
It provides basic CRUD functionalities on inventory items, which are called [`Product`](https://github.com/valyippee/shopify-challenge/blob/main/src/main/java/entity/Product.java)
entities in this application.
The additional feature implemented was the ability to create [`Shipment`](https://github.com/valyippee/shopify-challenge/blob/main/src/main/java/entity/Shipment.java) 
and assign an amount of `Product` to it specified by the user through the website. The inventory will then be adjusted appropriately. 

## Table of Contents
- Install
- Run
- Things to Note
- Bugs/ Issues

## Install
The technologies used are Java for the backend (with no frameworks), React for the frontend website, and Gradle for building the application.

### Technologies needed
- [Latest Java JDK installation](https://www.oracle.com/java/technologies/downloads/#jdk17-linux)
  - Note that you have to set `JAVA_HOME` too. See [this](https://docs.oracle.com/cd/E19509-01/820-3208/inst_cli_jdk_javahome_t/).
- [Nodejs](https://nodejs.org/en/download/)
- An IDE (such as [Intellij](https://www.jetbrains.com/idea/download/#section=windows)) or a command prompt (I have tested the commands on Windows and Linux, but I am not sure if it works with MacOS. If it doesn't, try running the application from an IDE)

#### Installing Java JDK and Nodejs in linux system
Install `Nodejs`:
```
sudo apt install nodejs
```
Install Java JDK:
```
sudo apt install openjdk-11-jdk
```
Set `JAVA_HOME`:
```
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
```

## Run
To run this application, clone this repository and navigate to the root of the project. 

You will have to run the frontend and backend seperately. By default, the frontend runs on port 3000 and the backend runs on port 4567.

### To run the backend:

#### Using Windows command prompt

Use Gradle wrapper to build the application using the command

```
.\gradlew build
```

The build could fail. See [this issue](https://github.com/valyippee/shopify-challenge/issues/6) and follow the steps to resolve the error.

After resolving the issue, run the `.\gradlew build` command again to finish the build.

A jar file will be created at the relative path `\build\libs`

Run 
```
java -jar .\build\libs\shopify-challenge-1.0-SNAPSHOT-all.jar
``` 
to start the backend server.

#### Using Linux command prompt

Before building the application with the Gradle wrapper, run
```
sed -i.bak 's/\r$//' gradlew
```
to change carriage return. See [this](https://stackoverflow.com/a/58002557/15751775) for more information.

Next, use Gradle wrapper to build the application using the command

```
./gradlew build
```

The build could fail. See [this issue](https://github.com/valyippee/shopify-challenge/issues/6) and follow the steps to resolve the error.

After resolving the issue, run the `./gradlew build` command again to finish the build.

A jar file will be created at the relative path `\build\libs`

Run 
```
java -jar ./build/libs/shopify-challenge-1.0-SNAPSHOT-all.jar
``` 
to start the backend server.

#### Using an IDE
Navigate to and run the main class at `src/main/java/launcher/Main.java`.

### To run the frontend:

#### Using Windows command prompt

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
