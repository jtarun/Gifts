#     Gifts

## How to build and run application
1) Make sure maven is installed.

2) There are two main classes in the project - FindPair and FindTriplet. To compile FindPair, run the following:
   mvn clean package -Dstart-class=com.paxos.challenge.gifts.FindPair

3) Now run the code using the following command -
   java -jar target/Gifts-0.0.1-SNAPSHOT.jar PATH_TO_GIFTS_FILE 2300

   Similarly to compile the FindTriplet, run the following command:
   mvn clean package -Dstart-class=com.paxos.challenge.gifts.FindTriplet