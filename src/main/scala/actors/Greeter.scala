package actors

import actors.Greeter.{Greet, WhoToGreet}
import actors.Printer.Greeting
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object Greeter {
  def props(message: String, printerRef: ActorRef): Props = Props(new Greeter(message, printerRef))

  final case class WhoToGreet(who: String)
  case object Greet
}

class Greeter(message: String, printerRef: ActorRef) extends Actor with ActorLogging {
  var greeting = ""

  override def receive: Receive = {
    case WhoToGreet(who) => greeting = s"$who, $message"
    case Greet => printerRef ! Greeting(greeting)
  }
}