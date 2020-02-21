package lectures.part2OOP

import scala.language.postfixOps

object AnonymusClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //anonymus class
  val anAnimal: Animal = new Animal {
    override def eat: Unit = println("Hahahahha")
  }

  anAnimal eat

  println(anAnimal.getClass)

  class Person(name: String) {
    def apply(n: Int): Unit = println(s"I've just made $n pushups!")
  }

  val jim: Person = new Person("Jim")
  jim(10)

  //every trait and class can ben ovveridden as the way we did at anonymus class
  val donat: Person = new Person("Donat") {
    override def apply(n: Int): Unit = println(s"I've just drank $n biers!")
  }

  donat(5)


}
