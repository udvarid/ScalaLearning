package lectures.part3FP

import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {

  val aSucces = Success(3)
  val aFailure = Failure(new RuntimeException("hhh"))

  println(aSucces)
  println(aFailure)

  def unsafeMethod(): String= throw new RuntimeException("ez egy hiba")

  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  println(potentialFailure.isSuccess)

  def backupMethod(): String = "A valid result"

  def fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))

  println(fallbackTry)

  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid method")

  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  println(betterFallback)

  //map, flatmap, filter

  println(aSucces.map(_ * 2))
  println(aSucces.flatMap(x => Success(x * 10)))
  println(aSucces.filter(_ > 10))

}
