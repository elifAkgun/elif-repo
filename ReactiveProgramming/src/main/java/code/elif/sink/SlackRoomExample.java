package code.elif.sink;

import reactor.core.publisher.Sinks;

public class SlackRoomExample {

    public static void main(String[] args) throws InterruptedException {
        Sinks.Many<String> slackRoom = Sinks.many().replay().all();

        String userMike = "mike";
        joinRoom(slackRoom, userMike);
        publishMessageToRoom(userMike, "Hello", slackRoom);
        publishMessageToRoom(userMike, "Hi", slackRoom);
        publishMessageToRoom(userMike, "How are you", slackRoom);

        String userSam = "sam";
        joinRoom(slackRoom, userSam);

        publishMessageToRoom(userSam, "Hey", slackRoom);
        publishMessageToRoom(userSam, "What's up!", slackRoom);
        String userEmma = "emma";

        joinRoom(slackRoom, userEmma);
        publishMessageToRoom(userEmma, "Fine", slackRoom);
        publishMessageToRoom(userEmma, "You?", slackRoom);

        Thread.sleep(10000);

    }


    private static void publishMessageToRoom(String userName, String message, Sinks.Many<String> room) {
        room.tryEmitNext(userName + ":" + message);
    }

    private static void joinRoom(Sinks.Many<String> room, String userName) {
        System.out.println(userName + " is joined the room---");
        room.asFlux()
                .filter(msg -> !msg.contains(userName))
                .subscribe(msg -> System.out.println(msg + "->" + userName));
    }
}
