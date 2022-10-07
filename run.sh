cd ./redis.pup
./gradlew bootjar
cd ..
cd ./redis.sub
./gradlew bootjar
docker-compose up