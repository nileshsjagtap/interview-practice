package Cats

import cats.Semigroup
import cats.implicits._

object SemigroupExample extends App{

  println(Semigroup[Int].combine(1, 2))
  println(Semigroup[List[Int]].combine(List(1, 2, 3), List(4, 5, 6)))
  println(Semigroup[Option[Int]].combine(Option(1), Option(2)))
  println(Semigroup[Option[Int]].combine(Option(1), None))
  println(Semigroup[Int => Int].combine(_ + 1, _ * 10).apply(6))
  println(Map("foo" -> Map("bar" -> 5)).combine(Map("foo" -> Map("bar" -> 6), "baz" -> Map())))
  println(Map("foo" -> Map("bar" -> 5)) ++ Map("foo" -> Map("bar" -> 6), "baz" -> Map()))
}
