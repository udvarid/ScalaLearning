package lectures.part1Basics

object CLBNvsCLBV extends App{

  def calledByValue(x: Long): Unit = {
    println("Called by value " + x)
    println("Called by value " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("Called by name " + x)
    println("Called by name " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infiniteFunction(): Int = 1 + infiniteFunction()

  def calledByNameFunction(x: Int, y: => Int) = println("hello")

  calledByNameFunction(5,5)
  calledByNameFunction(5, infiniteFunction()) // this is ok, as the second parameter called by name
  //calledByNameFunction(infiniteFunction(), 5) // it will crash as the first parameter called by value

}
