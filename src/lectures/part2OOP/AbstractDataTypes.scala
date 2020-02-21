package lectures.part2OOP

object AbstractDataTypes extends App {

  //abstract
  abstract class Animal {
    val creaturType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creaturType: String = "Canine"

    def eat: Unit = println("crunch crunch")
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal) : Unit
    val preferredMeal: String = "fresh meat"
  }

  trait Coldblooded

  class Crocodile extends Animal with Carnivore with Coldblooded {
    override val creaturType: String = "croc"

    def eat: Unit = println("nomnomnom")

    def eat(animal: Animal): Unit = println(s"I am a Croc and I am eating a ${animal.creaturType}")

  }

  val dog = new Dog
  val croc = new Crocodile

  croc eat dog

  println(croc.preferredMeal)


}
