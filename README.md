# Game of Three


# Introduction
This game is built on event driven architecture which consist of two players
player-one and player-two both are subscribed to kafka topic and act as pub/sub

Player one generates a random integer num and publishes a Game event
Player two listens to that event and divides that number with 3 and publishes a Game Event
Whoever player gets result 1 will be the winner



# Steps to run the game from Console using Docker
1. Make sure you have Docker installed in your local system
2. Run command `` mvn clean package ``
4. Now run command 
```
docker-compose up -d 
docker-compose logs -f player-one (for player one)
docker-compose logs -f player-two (for player two)
```
5. Start the game by going to `localhost:8080/startGame`
6. See the logs who won



# Steps to run the game from IDEA
1. First make sure apache kafka and zookeeper are running on your localhost with port `9092`
2. Change the configs in `application.yml` from `kafka:19092` to ``localhost:9092``
2. Go to player-one directory and Run PlayerOneApplication.java
3. Go to player-two directory and Run PlayerTwoApplication.java
4. Start the game by going to `localhost:8080/startGame`
5. You will see the result on console of the both players who ever wins



# Improvements under progress
1. Implement test cases with embedded kafka