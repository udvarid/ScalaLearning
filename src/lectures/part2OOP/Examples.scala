package lectures.part2OOP

object Examples extends App {

  class Writer(firstName: String, lastName: String, val age: Int) {
    def fullName(): String = firstName + " " + lastName
  }

  class Novel(val name: String, val releaseYer: Int, val author: Writer) {
    def isWrittenBy(anotherAuthor: Writer): Boolean = author == anotherAuthor

    def authorAge(): Int = releaseYer - author.age

    def copy(): Novel = {
      new Novel(name, 2020, author)
    }
  }

  class Counter(val value: Int) {
    def inc = new Counter(value + 1)

    def dec = new Counter(value - 1)

    def inc(n: Int): Counter = {
      if (n <= 0) this
      else inc.inc(n - 1)
    }

    def dec(n: Int): Counter = {
      if (n <= 0) this
      else dec.dec(n - 1)
    }
  }

  val szam = new Counter(10)

  println(szam.dec.value)
  println(szam.inc.value)
  println(szam.dec(4).value)
  println(szam.inc(7).value)

}
