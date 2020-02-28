package lectures.part3FP

object PatternsEverywhere extends App {

  //big Idea #1

  try {
    //Code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b)

  val aList = List(1, 2, 3, 4)
  val head :: tail = aList
  println(head)
  println(tail)

  val mappedList = aList.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  } //partial function literal

  val mappedList2 = aList.map { x =>
    x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }

  // a kettő ugyanaz

  println(mappedList)
  println(mappedList2)


}
