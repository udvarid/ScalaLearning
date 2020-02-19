package lectures.part2OOP

import scala.language.postfixOps

object Notation extends App {

  class Person(val name: String, favouredMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouredMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(string: String): Person = new Person(s"$name ($string)", favouredMovie)
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favouredMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouredMovie"
    def apply(n: Int): String = s"$name watched $favouredMovie $n times"
    def learn(whatToLearn: String): String = s"$name learns $whatToLearn"
    def learnScala: String = this learn "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix notation = operator notation

  val tom = new Person("Tom", "Star Wars")

  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  //prefix notation
  val x = -1
  val y = 1.unary_-
  //unary works with + - ~ !

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  //--------excercises
  //1
  val newMary: Person = mary + "The rockstar"
  println(newMary.name)
  //2
  val agedMary: Person = +mary
  println(agedMary.age)

  println(mary learn "Python")
  println(mary learnScala)

  println(mary(7))

}
