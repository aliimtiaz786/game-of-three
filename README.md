# Game of Three


# Introduction
This game is built on event driven architecture which consist of two players
player-one and player-two both are subscribed to kafka topic and act as pub/sub

Player one generates a random integer num and publishes a Game event
Player two listens to that event and divides that number with 3 and publishes a Game Event
Whoever player gets result 1 will be the winner





# Steps to run the game from IDEA
1. First make sure apache kafka and zookeeper are running on your localhost with port `9092`
2. Go to player-one directory and Run PlayerOneApplication.java
3. Go to player-two directory and Run PlayerTwoApplication.java
4. You will see the result on console of the both players who ever wins




# Steps to run the game from Console using Docker
1. First make sure apache kafka and zookeeper are running on your localhost with port `9092`
2. Make sure you have Docker installed in your local system
3. Go to player-one directory and Run command ``./mvnw spring-boot:build-image ``
4. Go to player-two directory and Run command ``./mvnw spring-boot:build-image ``
4. Now run commands
```
docker run -p 8080:8080 docker.io/library/player-one:0.0.1-SNAPSHOT
docker run -p 8090:8090 docker.io/library/player-two:0.0.1-SNAPSHOT

```
5. You will see the result on console of the both players who ever wins

# Improvements under progress
1. Run all the services through docker compose and automate
2. Implement test cases with embedded kafka