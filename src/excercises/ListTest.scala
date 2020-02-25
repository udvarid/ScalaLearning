package excercises

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  //higher-order functions
  def map[B](transformer: A => B): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = Cons(element, Empty)

  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int) = Empty

  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists don't have the same length!")
    else Empty
  }

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A] = Empty) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B](transformer: A => B): MyList[B] = t.map(transformer).add(transformer(head))

  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(head)) t.filter(predicate).add(head)
    else t.filter(predicate)
  }

  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists don't have the same length!")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  override def fold[B](start: B)(operator: (B, A) => B): B =
    t.fold(operator(start, h))(operator)
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val listOfIntegers2: MyList[Int] = Cons(4, Cons(5, Cons(6, Empty)))
  val listOfStrings: MyList[String] = Cons("2", Cons("5", Cons("8", Empty)))
  val listOfStrings2: MyList[String] = Cons("Alma", Cons("Körte", Cons("Banán", Empty)))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  val evenNumber: Int => Boolean = _ % 2 == 0

  val greaterThanOne: Int => Boolean = _ > 1

  println(listOfIntegers.filter(evenNumber).toString)
  println(listOfIntegers.filter(greaterThanOne).toString)

  val stringToInt: String => Int = _.toInt

  println(listOfStrings.map(stringToInt).filter(evenNumber).toString)

  val flattMapper: Int => MyList[Int] = x => {
    val flattedMap: MyList[Int] = Cons(x + 2)
    flattedMap.add(x + 1).add(x)
  }

  println("-------------------")

  println(listOfIntegers.flatMap(flattMapper).toString)

  val kicsinyke = new Function1[String, MyList[String]] {
    override def apply(a: String): MyList[String] = {
      val kicsinykeMap: MyList[String] = Cons(a + "écske")
      kicsinykeMap.add(a)
    }
  }

  println(listOfStrings2.flatMap(kicsinyke).toString)

  println("-----------------------------")
  listOfIntegers.foreach(x => println(x))

  println("-----------------------------")
  listOfIntegers.foreach(println)

  println("----------------------------")
  println(listOfIntegers.toString)
  println(listOfIntegers.sort((x, y) => y - x))

  println("----------------------------")
  println(listOfIntegers.zipWith[Int, Int](listOfIntegers2, _ +  _).toString)

  println("----------------------------")

  println(listOfIntegers2.fold(0)(_ + _))
  println(listOfIntegers.fold(0)(_ + _))

  println(listOfIntegers.zipWith[Int, Int](listOfIntegers2, _ + _).fold(0)(_ + _))

}
