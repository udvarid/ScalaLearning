package lectures.part2OOP

object Objects {

  //Scala application has to have an extends App or a method def main
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFlye)

    //Scala object is a Type and a Singleton Instance

    val mary = Person
    val john = Person
    println(mary == john) //true

    val peter = new Person("Peter")
    val chris = new Person("Chris")
    println(peter == chris) //false

    val bobby = Person.from(peter, chris )
    val bobby2 = Person(peter, chris ) // with apply method

  }


  //object like static object
  object Person {
    //static/class level functionality
    val N_EYES = 2
    def canFlye: Boolean = false

    //factory method
    def from(mother: Person, father: Person): Person = new Person("Bobby")
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    //instance level functionality
  }
  //COMPANIONS



}
