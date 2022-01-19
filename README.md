# shopify-backend-developer-challenge

This is an inventory tracking web application for a logistics company. 
It provides basic CRUD functionalities on inventory items, which are called [`Product`](https://github.com/valyippee/shopify-challenge/blob/main/src/main/java/entity/Product.java)
entities in this application.
The additional feature implemented was the ability to create [`Shipment`](https://github.com/valyippee/shopify-challenge/blob/main/src/main/java/entity/Shipment.java) 
and assign an amount of `Product` to it specified by the user through the website. The inventory will then be adjusted appropriately. 

## Table of Contents
- [Install](#install)
- [Run](#run)
- [Things to Note](#things-to-note)
- [Additional comments](#additional-comments)

## Install
The technologies used are Java for the backend (with no frameworks), React for the frontend website, and Gradle for building the application.

### Technologies needed
- [Latest Java JDK installation](https://www.oracle.com/java/technologies/downloads/#jdk17-linux)
  - Note that you have to set `JAVA_HOME` too. See [this](https://docs.oracle.com/cd/E19509-01/820-3208/inst_cli_jdk_javahome_t/).
- [Nodejs](https://nodejs.org/en/download/)
- An IDE (such as [Intellij](https://www.jetbrains.com/idea/download/#section=windows)) or a command prompt (I have tested the commands on Windows and Linux, but I am not sure if it works with MacOS. If it doesn't, try running the application from an IDE)

#### Installing Java JDK and Nodejs 

##### Linux system
Install `Nodejs`, `npm, and Java JDK:
```
# update
sudo apt update

# install nodejs
sudo apt install nodejs

# install npm
sudo apt install npm

# install Java JDK:
sudo apt install openjdk-11-jdk
```

Set `JAVA_HOME`:
```
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
```

##### Windows

See the links provided [previously](#technologies-needed).

## Run
To run this application, clone this repository and navigate to the root of the project. 

You will have to run the frontend and backend separately. By default, the frontend runs on port 3000 and the backend runs on port 4567.

**Important**: If you were to change port for the backend server, also change `"proxy": "http://localhost:4567"` to `"proxy": "http://localhost:<new_port_number>"`
in `src/main/frontend/package.json` for the requests from frontend to be correctly routed to the backend server.

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

Note that `/` is used in Linux instead of ` \ `.  

The build could fail. See [this issue](https://github.com/valyippee/shopify-challenge/issues/6) and follow the steps to resolve the error.

After resolving the issue, run the `./gradlew build` command again to finish the build.

A jar file will be created at the relative path `/build/libs`

Run 
```
java -jar ./build/libs/shopify-challenge-1.0-SNAPSHOT-all.jar
``` 
to start the backend server.

#### Using an IDE
Navigate to and run the main class at `src/main/java/launcher/Main.java`.

### To run the frontend:

#### Using Windows or Linux command prompt

Change directory to the frontend folder: `src\main\frontend` and run 
```
npm start
```
to start the frontend.

## Things to Note
#### Navigating through the website
- From the navigation sidebar, there are options to view the products or shipments. The create buttons in each page brings you to the page to create products and shipments respectively. 
- In the products' view page, you can choose to edit or delete each product.

#### Format of inputs when creating/ editing entities from the website
- When creating/editing products, current inventory and minimum inventory have to be non-negative whole numbers.
- Name of products and shipments cannot be empty, but they do not have to be unique.
- When creating a new shipment, you can input the amount of each product to be included in that shipment. However, you should fill in amounts for every product and not leave any of them blank. See [this issue](https://github.com/valyippee/shopify-challenge/issues/8) for more details. 

## Additional comments
1. The frontend code was based on this [template](https://www.bootstrapdash.com/product/star-admin-react-free/).
2. The web application supports CRUD operations on `Product` and only create and read operations on `Shipment`.
3. It may seem idiosyncratic to go through the long process of building a jar file to start the backend and at the same time start the frontend app seperately. The ultimate goal was to package the frontend app together with the backend code as an executable jar, so that anyone who wants to run the code would just need to have java jdk and run the application as a whole jar file. Another approach could be to use Docker that makes the application more portable. Unfortunately, I could not figure it out in time for the internship application, but it is definitely something to look into for me in the future.
4. There is an attribute called `ShipmentStatus` in the entity class `Shipment`. For simplicity and due to time constraints, I implemented it as a enum with various values to indicate the status of the shipment (whether it has been processed, shipped, etc). However, there are much more room to improve on that, as the "status" of a shipment constitutes many more information, such as time at which the current status is gained (e.g. delivered time), location, and previous statuses etc. I thought of using a composite pattern since a status can contain other statuses. Another approach could be the chain of responsibility pattern, where each status is thought of as a request handler, and they can pass on the "request" to the next handler, which is another status. Currently, I am not sure what is the best approach, but if time permits, it would be an interesting area for me to think more about and implement.

