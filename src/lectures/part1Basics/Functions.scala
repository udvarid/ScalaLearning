package lectures.part1Basics

object Functions extends App {

  def aFunction(a: Int, b: String): String = {
    a + " " + b
  }

  println(aFunction(3, "hello"))

  def aRepeatedFunction(s: String, n: Int): String = {
    if (n == 1) s
    else s + aRepeatedFunction(s, n - 1)
  }

  println(aRepeatedFunction("Donát", 4))

  def aFunctionWithSideEffect(s: String): Unit = println(s)

  aFunctionWithSideEffect("Kaki")

  def aBigfunction(a: Int): Int = {
    def aSmallfunction(b: Int, c: Int): Int = b + c

    aSmallfunction(a, a - 1)
  }

  println(aBigfunction(10))

  def aGreetingFunction(name: String, age: Int): String =
    "Hello, my name is " + name + " and I am " + age + " years old"

  println(aGreetingFunction("Donát", 42))

  def aFactorialFunction(n: Int): Int =
    if (n == 1) 1
    else n * aFactorialFunction(n - 1)

  println((aFactorialFunction(5)))

  def aFibonacciFunction(n: Int): Int =
    if (n <= 2) 1
    else aFibonacciFunction(n - 1) + aFibonacciFunction(n - 2)

  def aFibonacciRunner(n: Int): Unit = {
    println(n + " - " + aFibonacciFunction(n))
    if (n > 1) aFibonacciRunner(n - 1)
  }

  aFibonacciRunner(10)

  def aPrimeNumberTesterFunction(n: Int): Boolean = {
   def aDividerFunction(a: Int): Boolean = {
      if (a > n / 2) true
      else {
        if (n % a == 0) false
        else aDividerFunction(a + 1)
      }
   }
    aDividerFunction(2)
  }

  def aPrimeRunner (n: Int): Unit = {
    println(n + " - " + aPrimeNumberTesterFunction(n))
    if (n > 1) aPrimeRunner(n - 1)
  }

  aPrimeRunner(20)
}

