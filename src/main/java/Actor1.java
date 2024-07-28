import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Actor1 extends AbstractActor {

    public static Props props() {
        return Props.create(Actor1.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, msg -> {
                    if (msg.equals("Hi from Actor2")) {
                        System.out.println("Actor1 received: " + msg);
                    }
                })
                .matchAny(msg -> System.out.println("Actor1 received unknown message"))
                .build();
    }
}

