package lectures.part1Basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): BigInt = {

    @tailrec  //ezzel az annotációval jelzem a fordítnak, hogy tail rekurzív függvényt akarok csinálni
    def axFact(n: Int, kum: BigInt): BigInt =
      if (n <= 1) kum
      else axFact(n - 1, n * kum)

    axFact(n, 1)
  }

  println(factorial(50))


  def aRepeatedFunction(s: String, n: Int): String = {
    @tailrec
    def axRepeat(s: String, n: Int, sKum: String): String =
    if (n == 1) sKum
    else axRepeat(s, n - 1, sKum + s)

    axRepeat(s, n, s)
  }

  println(aRepeatedFunction("Donát", 4))


}
