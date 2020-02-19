package lectures.part2OOP

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  person.greet()
  person.greet("Donát")

  val person2 = new Person()
  person2.greet()
  println(person2.age)

  val person3 = new Person("frakk")
  person3.greet()
  println(person3.age)


}

class Person(name: String, val age: Int) {
  val x = 2

  println("hello")

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name!")

  //overloading
  def greet(): Unit = println(s"${this.name} is my name!")

  //multiple constructions or overloading construction
  def this(name: String) = this(name, 0)
  def this() = this("Donát", 34)
}

//constructor. If you parameter is not defined as 'val'
// it won't be a field, just a parameter
