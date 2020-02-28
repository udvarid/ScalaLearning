package lectures.part4PatternMatching

import scala.util.Random

object PatternMatching extends App {

  //switch on streoids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "The One"
    case 2 => "Double"
    case 3 => "Three"
    case _ => "Something else"  // ez kell, különben Matcherror-t kapunk ha nem talál
  }

  println(x)
  println(description)

  //decompose valuse
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 24)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I'm $a years old and I can't drink in US"
    case Person(n, a) => s"Hi, my name is $n and I'm $a years old"
    case _ => "I don't who I am"
  }

  println(greeting)

  //excercises
  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = {
    def maybeShowPar(e: Expr) = e match {
      case Prod(_, _) => show(e)
      case Number(_) => show(e)
      case _ => "(" + show(e) + ")"
    }

    e match {
      case Number(n) => s"$n"
      case Sum(e1, e2) => show(e1) + " + " + show(e2)
      case Prod(e1, e2) => maybeShowPar(e1) + " * " + maybeShowPar(e2)

    }
  }

  println(show(Number(2)))
  println(show(Sum(Number(2), Number(5))))
  println(show(Prod(Number(2), Number(5))))
  println(show(Sum(Number(8), Prod(Number(2), Number(5)))))
  println(show(Prod(Number(8), Sum(Number(2), Number(5)))))
  println(show(Prod(Sum(Number(8), Number(66)), Sum(Number(2), Number(5)))))

}
