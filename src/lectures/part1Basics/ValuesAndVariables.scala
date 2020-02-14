package lectures.part1Basics

object ValuesAndVariables extends App {

  //VAL is immutable
  val x: Int = 42
  println(x)

  //Compiler can infer types
  val y = 40
  println(y)

  val aString: String = "hello, Scala"
  val bString = "hello, Scala"
  println(aString)
  println(bString)

  val bolean: Boolean = true
  val aChar: Char = 'a'
  println(bolean)
  println(aChar)

  val shortNumber: Short = 544
  println(shortNumber)

  val aLong: Long = 34343434L

  val aFlot: Float = 3534.3434f
  val aDouble: Double = 3434.56

  //variables

  var aVariable: Int = 76
  println(aVariable)
  aVariable = 78
  println(aVariable)
}
