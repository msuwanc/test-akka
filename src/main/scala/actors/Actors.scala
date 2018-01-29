package actors

import akka.actor.{ActorRef, ActorSystem}

object Actors {
  val system: ActorSystem = ActorSystem("testAkka")

  val printerActor: ActorRef = system.actorOf(Printer.props, "printerActor")
  val greetingActor: ActorRef = system.actorOf(Greeter.props("Hello there", printerActor), "greeting1Actor")
  val greeting2Actor: ActorRef = system.actorOf(Greeter.props("What's up", printerActor), "greeting2Actor")
  val greeting3Actor: ActorRef = system.actorOf(Greeter.props("Hello world", printerActor), "greeting3Actor")

  def createGreeter(message: String, printer: ActorRef, greeterName: Option[String]): ActorRef = greeterName match {
    case Some(value) => system.actorOf(Greeter.props(message, printer), value)
    case None => system.actorOf(Greeter.props(message, printer))
  }
}
