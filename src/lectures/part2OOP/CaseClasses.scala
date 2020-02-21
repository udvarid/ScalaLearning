package lectures.part2OOP

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 34)

  //1. class parameters are fields
  println(jim.name)
  println("-------")

  //2. sensible to toString
  println(jim.toString)
  println(jim)
  println("-------")

  //3. equals and hashcode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)
  println("-------")

  //4. Case class-es have handy copy methods
  val jim3 = jim.copy()
  println(jim3 == jim2)
  val jim4 = jim.copy(age = 45)
  println(jim4)
  println(jim4 == jim)
  println("-------")

  //5. case classes have companion objects
  val thePerson = Person
  val donat = thePerson("Donat", 34)
  println(donat)
  val mary = Person("Mary", 40) // -> az object apply metódusát hívja meg és hoz létre egy új class-t
  println(mary)
  println(mary.name)
  println(mary.age)
  println("-------")

  //6. case classes are serializable
  //Akka

}
