package excercises

abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A] = Empty) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = Cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B](transformer: MyTransformer[A, B]): MyList[B] = t.map(transformer).add(transformer.transform(head))

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(head)) t.filter(predicate).add(head)
    else t.filter(predicate)
  }

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)
}

trait MyPredicate[-T] {
  def test(variable : T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val listOfStrings: MyList[String] = Cons("2", Cons("5", Cons("8", Empty)))
  val listOfStrings2: MyList[String] = Cons("Alma", Cons("Körte", Cons("Banán", Empty)))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  val evenNumber = new MyPredicate[Int] {
    def test(variable: Int): Boolean = variable % 2 == 0
  }

  val greaterThanOne = new MyPredicate[Int] {
    def test(variable: Int): Boolean = variable > 1
  }

  println(listOfIntegers.filter(evenNumber).toString)
  println(listOfIntegers.filter(greaterThanOne).toString)

  val stringToInt = new MyTransformer[String, Int] {
    def transform(a: String): Int = a.toInt
  }

  println(listOfStrings.map(stringToInt).filter(evenNumber).toString)

  val flattMapper = new MyTransformer[Int, MyList[Int]] {
    def transform(a: Int): MyList[Int] = {
      val flattedMap: MyList[Int] = Cons(a + 2)
      flattedMap.add(a + 1).add(a)
    }
  }

  println("-------------------")

  println(listOfIntegers.flatMap(flattMapper).toString)

  val kicsinyke = new MyTransformer[String, MyList[String]] {
    override def transform(a: String): MyList[String] = {
      val kicsinykeMap: MyList[String] = Cons(a + "écske")
      kicsinykeMap.add(a)
    }
  }

  println(listOfStrings2.flatMap(kicsinyke).toString)


}
