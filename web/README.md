Backend with Springboot & MySQL - Blue Green Deployment with AWS CodePipeline 
===================================

Pre-requisites
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Run SJApplication
Modify Application Context in src/main/java/com/sj/entity/config/JerseyConfig.java

Reference
---------------
application.properties
JerseyConfig


Database
---------------
#### MY SQL
Start with db_scripts folder

    CREATE USER 'sanjay'@'localhost' IDENTIFIED BY 'password';
    GRANT ALL PRIVILEGES ON *.* TO 'sanjay'@'localhost';
    exit
    
    mysql -u sanjay -p
    CREATE DATABASE IF NOT EXISTS `backendappdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

    In Intellij, connect with database & run the dml & ddl scripts.
    sj-springboot-mysql-crud/web/db_scripts
    
    Name: backendappdb, User: sanjay, Password: password


Build
---------------
##### Build Project 
cd sj-springboot-mysql-crud/web

./gradlew clean (if necessary)

./gradlew build

        :compileJava
        :processResources
        :classes
        :findMainClass
        :jar
        :bootRepackage
        :assemble
        :compileTestJava UP-TO-DATE
        :processTestResources UP-TO-DATE
        :testClasses UP-TO-DATE
        :test UP-TO-DATE
        :check UP-TO-DATE
        :build
        
        BUILD SUCCESSFUL

##### Start Server 
java -jar build/libs/backendapp-1.0.jar
 

Testing
---------------

#### Get all entities 
    http://127.0.0.1:8090/backendapp/entity/all
    {"entities":[{"entityId":1,"name":"Entity1"},{"entityId":2,"name":"Entity2"}]}

#### Get one entity
    http://127.0.0.1:8090/backendapp/entity/<entityId>
    http://127.0.0.1:8090/backendapp/entity/1
    {"entity":{"entityId":1,"name":"Entity1","description":"desc"}}

#### Delete entity
    http://127.0.0.1:8090/backendapp/entity/delete/<entityId>
    http://127.0.0.1:8090/backendapp/entity/delete/2  
    {"deleteStatus":true}

Troubleshooting
=======================================================
Intellij may have issues with POJO lombok processing. Enable Annotation Processing in Settings.

If getting caching_sha2_password error,
java.sql.SQLException: Unable to load authentication plugin 'caching_sha2_password'.
Login mysql with root & alter user to use native password
ALTER USER 'sanjay'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';        