package lectures.part1Basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(x: Int, akk: Int = 1): Int =
    if (x <= 1) akk
    else trFact(x - 1, x * akk)

  println(trFact(10))

  def wellcomeFunction(name: String = "Donát", age: Int = 42): String =
    s"Hello, my name is $name and I am $age old!"

  println(wellcomeFunction())
  println(wellcomeFunction("Béla", 50))
  println(wellcomeFunction("Géza"))
  println(wellcomeFunction(age = 78, name = "Zsuzsanna"))
}
