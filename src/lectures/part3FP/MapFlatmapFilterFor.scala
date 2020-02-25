package lectures.part3FP

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)

  println(list)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " Hello"))

  println(list.filter(_ % 3 == 0))

  //flatmap
  var toPair = (x: Int) => List(x, x + 4)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("Black", "White")

  //iterating
  val combination = numbers.flatMap(x => chars.map(c => "" + c + x))
  println(combination)

  //foreach
  list.foreach(println)

  //for comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0 //embedded filter
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  forCombinations.foreach(println)

  for {
    n <- numbers
  } println(n)

  //syntax overload
  val newList = list.map { x =>
    x * 2
  }
  println("---------")
  println(list)
  println(newList)
}
