package lectures.part3FP

import scala.util.Random

object Optional extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  //unsafe API
  def unSafeMethod(): String = null

  val result = Some(unSafeMethod()) //Wrong
  val resultOption = Option(unSafeMethod())

  println(result)
  println(resultOption)

  //unsafe methods
  def backupMethod(): String = "A valid result"

  val chainedResult = Option(unSafeMethod()).orElse(Option(backupMethod()))

  println(chainedResult)

  //DESIGN unsafe API
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid method")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainedResult)

  //function on Options
  println(myFirstOption.isEmpty)
  //println(myFirstOption.get)
  //println(noOption.get) // Unsafe, not to use

  //map, flatmap, filter

  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  val config: Map[String, String] = Map(
    "host" -> "hello",
    "port" -> "hallo"
  )


  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  //try to establish a connection
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(x => x.connect)
  connectionStatus.foreach(println)

  //chained calls
  println("-------------")
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  println("-------------")
  //for comprehensions
  val connectionStatus2 = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  connectionStatus2.foreach(println)

}
