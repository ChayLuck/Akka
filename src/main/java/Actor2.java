import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Actor2 extends AbstractActor {

    private final ActorRef actor1;

    public Actor2(ActorRef actor1) {
        this.actor1 = actor1;
    }

    public static Props props(ActorRef actor1) {
        return Props.create(Actor2.class, actor1);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, msg -> {
                    if (msg.equals("Hi from Actor1")) {
                        System.out.println("Actor2 received: " + msg);
                        actor1.tell("Hi from Actor2", getSelf());
                    }
                })
                .matchAny(msg -> System.out.println("Actor2 received unknown message"))
                .build();
    }
}
