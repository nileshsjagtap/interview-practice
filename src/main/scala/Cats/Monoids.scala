package Cats

import cats._
import cats.implicits._

object Monoids extends App{

  println(Monoid[String].empty)
  println(Monoid[String].combineAll(List("a", "b", "c")))
  println(Monoid[String].combineAll(List()))


  println(Monoid[Map[String, Int]].combineAll(List(Map("a" -> 1, "b" -> 2), Map("a" -> 3))))
  println(Monoid[Map[String, Int]].combineAll(List()))


  val l = List(1, 2, 3, 4, 5)
  println(l.foldMap(identity))
  println(l.foldMap(i => i.toString))


//  implicit def monoidTuple[A: Monoid, B: Monoid]: Monoid[(A, B)] =
//    new Monoid[(A, B)] {
//      def combine(x: (A, B), y: (A, B)): (A, B) = {
//        val (xa, xb) = x
//        val (ya, yb) = y
//        (Monoid[A].combine(xa, ya), Monoid[B].combine(xb, yb))
//      }
//      def empty: (A, B) = (Monoid[A].empty, Monoid[B].empty)
//    }

  println(l.foldMap(i => (i, i.toString)))

}
