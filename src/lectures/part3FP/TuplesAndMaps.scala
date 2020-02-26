package lectures.part3FP

import scala.annotation.tailrec

object TuplesAndMaps extends App {

  //tupples = finite ordered "list"
  val aTuple = new Tuple2(2, "Hello Scala")
  val aTuple2 = (2, "Hello Scala")

  println(aTuple._1)
  println(aTuple.copy(_2 = "Goodbye Java"))
  println(aTuple.swap)

  //map
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map("Donát" -> 555, "Péter" -> 444).withDefaultValue(-1)
  println(phoneBook)

  println(phoneBook.contains("Donát"))
  println(phoneBook("Donát"))
  println(phoneBook("Donátocska"))

  //add a pairing
  val newPairing = "Mary" -> 4534
  val newPhonebook = phoneBook + newPairing
  println(newPhonebook)

  //functionals on Map
  //map, flatmap, filter
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2 * 2))

  //filterkeys
  println(phoneBook.view.filterKeys(x => x.startsWith("D")).toList.toMap) //ez így biztos nem jó, de vmiért az eredményt nem értékelte ki

  //mapvalues
  println(phoneBook.view.mapValues(number => "444-" + number).toList.toMap)

  //conversions to other collections
  println(phoneBook.toList)
  val names = List("Donát", "Dávid", "Péter", "Kriszta", "Pál", "Gábor")
  println(names.groupBy(name => name.charAt(0)))

  //excercise
  val newPairing2 = "DONÁT" -> 556
  val phoneBook2 = phoneBook + newPairing2
  println(phoneBook2)
  println(phoneBook2.map(pair => pair._1.toLowerCase -> pair._2))
  //Excercies -> social networks

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unFriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unFriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(add(add(add(empty, "Mary"), "Bob"), "Donát"), "Frakk"), "Rumcájsz")

  println(network)
  println(friend(network, "Mary", "Donát"))
  println(unFriend(friend(network, "Mary", "Donát"), "Donát", "Mary"))
  println(remove(friend(network, "Mary", "Donát"), "Donát"))

  val maryDonat = friend(network, "Mary", "Donát")
  val testNet = friend(friend(maryDonat, "Mary", "Bob"), "Frakk", "Rumcájsz")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Kriszta"))
  println(nFriends(testNet, "Donát"))
  println(nFriends(testNet, "Mary"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriend(network: Map[String, Set[String]]): Int =
    network.count(person => person._2.isEmpty)

  //network.count(_._2.isEmpty)

  println(nPeopleWithNoFriend(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, cp: Set[String], dp: Set[String]): Boolean = {
      if (dp.isEmpty) false
      else {
        val person = dp.head
        if (person == target) true
        else if (cp.contains(person)) bfs(target, cp, dp.tail)
        else bfs(target, cp + person, dp.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Bob", "Donát"))
  println(socialConnection(testNet, "Frakk", "Rumcájsz"))
  println(socialConnection(testNet, "Frakk", "Donát"))

}
