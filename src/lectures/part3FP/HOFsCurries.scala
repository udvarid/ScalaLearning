package lectures.part3FP

object HOFsCurries extends App {

  //val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
  //HOF - Higher order function

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  val multiplyWith2AndAdd3 = (x: Int) => x * 2 + 3

  println(nTimes(plusOne, 4, 10))
  println(nTimes(multiplyWith2AndAdd3, 4, 5))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val increment10 = nTimesBetter(plusOne, 10)
  println(increment10(7))

  //curried functions

  val superFunction: Int => Int => Int = x => y => x + y
  println(superFunction(8)(9))

  //functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  def numberChanger(m: Int)(n: Int): Boolean = m * n > 50

  def versionOne: Int => Boolean = numberChanger(2)
  def versionTwo: Int => Boolean = numberChanger(3)

  println(versionOne(24))
  println(versionTwo(24))

}
