import actors.Actors
import actors.Greeter.{Greet, WhoToGreet}

object Main extends App {
  Actors.greetingActor ! WhoToGreet("Akka")
  Actors.greetingActor ! Greet
  Actors.greeting2Actor ! WhoToGreet("Play")
  Actors.greeting2Actor ! Greet
  Actors.greeting3Actor ! WhoToGreet("Scala")
  Actors.greeting3Actor ! Greet

  val greeter4 = Actors.createGreeter("Sa wad dee krub", Actors.printerActor, Some("greeter4"))
  greeter4 ! WhoToGreet("Google")
  greeter4 ! Greet

//  Actors.greetingActor ! Greet
//  Actors.greetingActor ! WhoToGreet("Akka")
//  Actors.greeting2Actor ! Greet
//  Actors.greeting2Actor ! WhoToGreet("Play")
//  Actors.greeting3Actor ! Greet
//  Actors.greeting3Actor ! WhoToGreet("Scala")
}