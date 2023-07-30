TAMAGOTCHI GAME

IDEs:
1. IntelliJ IDEA		   2022.2.2 (Runtime version 17.0.4+7)
2. Visual Studio Code 		   1.80.2

TECHNOLOGIES & LIBRARIES USED:
1. Springboot 			   3.1.2
2. Maven 			   4.0.0
3. Java 			   20
4. PostgreSQL 			   15.2
5. Postman 			   10.16.3
6. Angular	                   16.0.6
7. rxjs                            7.8.1
8. Typescript                      5.0.4
9. Bootstrap			   5.3.1

OS:
Windows 10 - win32 x64
(Hypothetically, others should also work seeing as it is a web app)

SPRING DEPENDENCIES:
1. spring-boot-starter-data-jpa
2. spring-boot-starter-validation
3. spring-boot-starter-web
4. postgresql
5. lombok
6. spring-boot-starter-test

SETUP / INSTALLATION:
1. Acquire both back-end & front-end versions
Back-end: https://github.com/TimofteRazvan/tamagotchi-backend
Front-end: https://github.com/TimofteRazvan/tamagotchi-frontend
2. Open Back-end project via Intellij Idea
3. Go to 'application.properties' file within /src/main/resources/application.properties
4. Edit spring.datasource.url=jdbc:postgresql://localhost:5432/{{PSQL DATABASE NAME HERE}} according to user's PSQL
5. Edit spring.datasource.username={{USERNAME}} & spring.datasource.password={{PASSWORD}} according to user's PSQL
6. Run project from file 'src/main/java/com/example/tamagotchibackend/TamagotchiBackendApplication.java'
!!!NOTE: There *might* be paths (libraries or imports), that may need to be changed according to the user who is
running the application, though I do not think there are any.
7. Open Front-end project via Visual Studio Code 'Open Folder'
8. Navigate to the project's main file (tamagotchi-frontend) in the terminal via CD
9. Write 'ng serve --open' in the terminal
10. You should be redirected to a new internet tab. If not, go to http://localhost:4200
!!!NOTE: Again, there *might* be paths (libraries or imports), that may need to be changed according to the user who is
running the application

PLAYING THE GAME:
1. Register a new user
2. Create your starting Tamagotchi (fill in name field and select the species you want your tamagotchi to be)
3. You will be redirected to the /home page, where you can see your Tamagotchi's status, development, etc.
4. Every second, all of the Tamagotchi's stats will fall by one, with a maximum value of '100' and a minimum value of '0'
5. If any of your Tamagotchi's stats fall down to 0, it will die/leave and you will have to create a new Tamagotchi
6. Your Tamagotchi's status will change if any of its stats go below 50 by telling you how it is currently feeling
7. Below its status, you can see your Tamagotchi's current development stage. Its visual will also change as it evolves.
(0-100 age - CHILD)
(100-200 age - TEENAGER)
(200+ age - ADULT)
8. Below the development stage, you can see its three values of HUNGER, HAPPINESS, CLEANLINESS and its current AGE
9. In order to refill the Tamagotchi's HUNGER/HAPPINESS/CLEANLINESS, you need to click on FEED/PLAY/CLEAN, respectively
10. There is also another button that allows the user to pre-emptively create a new Tamagotchi. The old one will be lost forever.
11. Finally, the 'log out' button ends the user's session and redirects them to the log in page.