package lectures.part1Basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 //IF expression
  println(aConditionedValue)

  //loop
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  var aVariable = 4

  val aWeirdValue = (aVariable = 3)

  println(aWeirdValue)

  val aCodeBlock = {
    val aa = 1
    val bb = 2

    if (aa > bb) "hello" else "goodbye"
  }
  //egy kód blokk értéke mindig az utolsó expression eredménye
  println(aCodeBlock)

  val tryblock = {
    2 + 4
  }
  println(tryblock)

}
