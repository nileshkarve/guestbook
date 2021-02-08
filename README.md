# guestbook
Guest book assignment for Spring-boot REST

How to start Spring-boot application?
1. Check out the code from git repo into a local folder.
2. Open "main/resource/config/database.properties" file and update database properties as applicable.
    a. Properties required to connect to a database are databseURL, databaseUserName, databasePassword, databaseDriverClassName(keep it as is if database beingused is MySQL or MariaDB)
    b. There is no need to create any schema in database. Project includes Liquibase which would take care of crating database and necessary tables along with default users.
3. Open command promt from the application folder where pom.xml is located.(/guestbook/guestbook)
4. Type and enter command "mvn spring-boot:run" in opened Command Prompt.

How to start Test the application?
1. Start both (Spring-boot and Angular) application on the machine.
2. Go to a web browser and hit URL : "loclhost:4200/login". This would land you on the home page of the application.
3. To login as Admin use username = "admin" and password = "password"
4. To login as Guest use one of the user names from following usernames = {"user1", "user2"} and password = "password"
