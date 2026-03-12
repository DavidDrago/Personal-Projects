Resources Needed:
Java JDK - https://www.oracle.com/in/java/technologies/downloads/#jdk25-windows
IntelliJ IDE - https://www.jetbrains.com/idea/download/?section=windows

Note:- Do remember to update the Environment Variables path with the JDK Bin, Javac.exe & java.exe after JDK installation.
"C:\Program Files\Java\jdk-25\bin\"
"C:\Program Files\Java\jdk-25\bin\java.exe"
"C:\Program Files\Java\jdk-25\bin\javac.exe"

Using Maven repository for dependencies
Selenium - https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
TestNG - https://mvnrepository.com/artifact/org.testng/testng
WebDriverManger - https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager

Creating Project in IntelliJ: 

Using Jenkins for CI/CD:
	Download Jenkins .war file to install with java.
	run "java -jar jenkins.war" or "java -jar jenkins.war --httpPort=8282"
	by default it will run in port 8080, we can mention the port we want to run by giving --httpPort
	password is given-c7fca9f4962a4c6490487c26a2e966d5
	After connecting to Jenkins, install "TestNG Results Plugin" and Maven Integration Plugin.
	Add Java JDK and Maven in tools by specifying the directory installed.
	After that we can check for their availability by creating a new freestyle project and configuring the Build Steps to check "java -version and mvn -version" using windows batch commands. Check console output for verification.
	mvn -Dmaven.test.failure.ignore = true clean test




Reference video for Selenium - https://www.freecodecamp.org/news/learn-java-testing-with-selenium/


