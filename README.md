# Prerequists to execute the project
* Java 1.8
* Maven 3 or above
* Api should be running on localmachine on port 9000 where test need to be performed

#### Use the following command to verify if java and maven is installed on the system
```sh
mvn --version
```
Should get something like below according your system and configurations
```sh
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T20:33:14+02:00)
Maven home: /usr/local/apache-maven-3.5.4
Java version: 1.8.0_171, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre
Default locale: en_SE, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.6", arch: "x86_64", family: "mac"
```

#### Following commands should be executed from project folder
  - To download only dependencies
```sh
$ mvn dependency:resolve
```
  - To execute project and create project documentation
```sh
$ mvn test site
```
  - To clean up repo
```sh
$ mvn clean
```
# Documentations/logs path (Surefire-report, java docs, Test application logs)

  - project folder/target/ExtentReport.html.html
  - project folder/application.log
# Limitations/Draw backs
  - Incomplete work
  - Hard coded data
  - Used rest-assured which cannot be used for performance testing
  
