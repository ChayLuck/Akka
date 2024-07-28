import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Actor1App {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ActorSystem1");

        ActorRef actor2 = system.actorOf(Props.create(Actor2.class, system.actorOf(Actor1.props())), "actor2");
        ActorRef actor1 = system.actorOf(Actor1.props(), "actor1");

        actor2.tell("Hi from Actor1", actor1);
    }
}
