import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Actor2App {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ActorSystem2");

        ActorRef actor1 = system.actorOf(Actor1.props(), "actor1");
        ActorRef actor2 = system.actorOf(Actor2.props(actor1), "actor2");

        actor1.tell("Hi from Actor2", actor2);
    }
}
