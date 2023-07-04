### Assignment


### Test Cases/flows that are implemented:
* Creation of a new user with mandatory and verification that it was saved successfully
* Update of existing user 
* Deletion of existing user
* Create an user with duplicated email (400)
* Create an user with invalid authentication token (401)

### Technical Stack

* Programming Language: Java
* Build tool: Gradle
* IDE: intelliJ IDEA
* Simple framework: TestNG (simple reporting)
* Testing Library: Rest-Assured
* Proper Reporting: Allure 

### Description

* REST API TEST FRAMEWORK

* Folder Structure:

* Src---> main
main has multiple folders:
1. constants --> EndPoint.Java (All the endpoints are listed/added here)

2. utils--> ConfigManagers.java (Using property file so I write config manager for that, config manager will have Private Constructor, Get instance, Get String , Input stream to load file)

3. helpers --> UserServiceHelper, It is very important file as all the requests and common methods are in this file.

4. model --> Account, Account_1, Profile **(Pojo class)**, that is used to map the keys.


* Src---> test
test has API test cases e.g CreateUser.java, UpdateUser.java

* resource has following files:
1. config.properties --> This file mainly contains information like baseURL, token etc.
2. TestNG (testng.xml)
3. Allure Report

### Execution of tests

There are 3 ways one can execute test cases:

1. Via gradle command in the terminal (intellij IDEA)
   * ./gradlew clean build
   * ./gradlew clean test OR  ./gradlew test

2. Via testng.xml file 
   * either run the test cases by opening the testng.xml file and right click *Run* option (This will alos provide basic reporting & detailed results)

3. Via Allure reporting **(Allure reporting has been added & configured within the project)**
   * This can be achieved if the system/computer has installed & configured allure to run the test cases locally
   * If allure is installed then do the following for detailed reporting results
       * Open the IDE terminal (intelliJ) and run this command ---> **allure serve ./allure-results/**


***PLEASE NOTE: The test cases are running smoothly by executing them using any of the above mentioned above ways. So in case of any failure please do check all the required configurations***
