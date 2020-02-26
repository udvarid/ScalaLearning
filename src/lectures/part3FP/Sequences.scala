package lectures.part3FP

import scala.util.Random

object Sequences extends App {

  //Seq
  println("Sequence ------------")
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  //Ranges
  println("Range ------------")
  val aRange: Seq[Int] = 1 to 10 //inclusive
  val aRange2: Seq[Int] = 100 until 105 //exclusive
  aRange.foreach(println)
  aRange2.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  //List
  println("List ------------")
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList //a lista elejére hozzátenni
  val prependedAndAppended = 42 +: aList :+ 78 //a lista elejére és végére hozzátenni

  println(prepended)
  println(prependedAndAppended)

  val apples5 = List.fill(5)("Apple")
  println(apples5)

  println(aList.mkString("-haha-"))

  //Array
  println("Array ------------")
  val anArray = Array(1, 2, 3, 4)
  anArray(2) = 0
  val threeElements = Array.ofDim[Int](3)
  val threeElements2 = Array.ofDim[String](3)

  anArray.foreach(println)
  threeElements.foreach(println)
  threeElements2.foreach(println)

  val numbersSeq: Seq[Int] = anArray
  println(numbersSeq)

  //vectors
  println("Vector ------------")
  val aVector: Vector[Int] = Vector(1, 2, 3)
  println(aVector)
  //vectors vs list
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // +keeps reference to tail
  // -updating takes long time
  println(getWriteTime(numbersList))
  // +depth of the three is small
  // -needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))

}
