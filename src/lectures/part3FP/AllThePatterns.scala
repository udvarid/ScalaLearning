package lectures.part3FP

import excercises.{MyList, Cons, Empty}

object AllThePatterns extends App {

  // 1 - Constants
  val x: Any = "Scala"

  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The True"
    case AllThePatterns => "A singleton object"
  }

  // 2 match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchVariable = x match {
    case something => s"I've found $something"
  }

  // 3. Tuples
  val aTuple = (3, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchaNestedTuple = nestedTuple match {
    case (_, (2, _)) =>
  }

  //4, case classes - constructor pattern
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
  }

  //5, list patterns
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => //extractor - advanced
    case List(1, _*) => //List of arbitrary length
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 42 => //infix pattern
  }

  //6, type specifier
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list : List[Int] => //explicit type specifier
    case _ =>
  }

  //7 name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => //name binding, use the name later here
    case Cons(1, rest @ Cons(2, _)) => //name binding, inside nester patterns
  }

  //8 multiple pattern
  val multiPattern = aList match {
    case Empty | Cons(0, _) => //component pattern
  }

  //9 if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement,_)) if specialElement % 2 == 0 =>
  }

  // ALL

}
