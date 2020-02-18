package lectures.part1Basics

object StringSmartOperations extends App {

  val str: String = "Hello, this is curse of Scala"

  println(str.charAt(2))
  println(str.substring(4, 15))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString: String = "678"
  val aNubmer: Int = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') //nem tudom ez miért jó
  println('a' + aNumberString + 'z')

  println(str.reverse)
  println(str.take(3))

  val name = "Donat"
  val age = 25
  val greetings = s"Az én nevem $name és a korom ${age + 4} lesz 4 év múlva"
  println(greetings)

  val speed = 1.2f

  val mtyh = f"$name%s meg tud enni $speed%2.2f hamburgert óránként!"
  println(mtyh)

  println("This is a \n newline")
  println(raw"This is a \n newline")

}
