# HOW TO INSTALL
1) download project from git repository
2) install java 8 if necessary
3) at the root of the project execute the command:
	- LINUX: ./mvnw clean spring-boot:run
	- WINDOWS: mvnw clean spring-boot:run
4) open a browser and go to http://localhost:8080/

# MANAGE H2 DB
1) The app is using an in-memory database H2. The data will only persist during app execution (all data will be lost when app is shutting down).
2) To access the H2 console, go to: http://localhost:8080/h2-console
3) login with: login=sa and no password required

# HOW TO TEST
1) at the root of the project execute the command:
	- LINUX: ./mvnw clean test
	- WINDOWS: mvnw clean test



