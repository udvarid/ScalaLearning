package lectures.part3FP

object AnonymousFunctions extends App {

  val doubler = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  //anonymous function, LAMBDA
  val doubler2: Int => Int = x => x * 2
  val doubler3 = (x: Int) => x * 2

  println(doubler(5))
  println(doubler2(5))
  println(doubler3(5))

  //multiple params
  val adder = (a: Int, b: Int) => a + b
  val adder2: (Int, Int) => Int = (a, b) => a + b

  println(adder(4,9))
  println(adder2(4,9))

  //noparams
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // function
  println(justDoSomething()) // function call

  //curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  println(stringToInt("5"))

  //MOAR synctatic sugar
  val niceIncrementer: Int => Int = _ + 1 //equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //equivalent to (a, b) => a + b

  val superAdd = (x: Int) => (y: Int) => x + y

  println(superAdd(8)(9))

}
