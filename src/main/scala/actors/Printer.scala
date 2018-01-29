package actors

import actors.Printer.Greeting
import akka.actor.{Actor, ActorLogging, Props}

object Printer {
  def props: Props = Props[Printer]

  case class Greeting(message: String)
}

class Printer extends Actor with ActorLogging {
  override def receive: Receive = {
    case Greeting(message) => log.info(s"Greeting received (from ${sender()}): $message")
  }
}
