package lectures.part2OOP

object Inharitence extends App {

  //single class inheritance
  class Animal {
    val creaturetype = "wild"

    def eat = println("ham")

    private def drink = println("gluk") // this can not be inherited
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch - crunch")
    }
  }

  val cat = new Cat
  cat.eat
  cat.crunch

  //constructions
  class Person(name: String, age: Int)

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //overrideing

  class Dog extends Animal {
    override val creaturetype: String = "Domestic"

    override def eat = {
      super.eat
      println("crunch-crunch-crunch")
    }
  }

  class Horse(override val creaturetype: String = "Tame and Domestic") extends Animal

  val dog = new Dog

  dog.eat
  println(dog.creaturetype)
  println(cat.creaturetype)

  val horse = new Horse

  println(horse.creaturetype)

  //poliformizsm
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat

  // preventing ovveride
  // use final keyword -> the method can not be overriden
  // use final at class level -> the class can not be extended
  // 'sealed' keyword on class level -> the class can be extended only in this file


}
