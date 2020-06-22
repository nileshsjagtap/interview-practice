package Cats

import cats.{Apply, Functor}
import cats.implicits._

object Functors extends App {

  println(Functor[List].map(List("qwer", "adsfg"))(_.length))

  val source = List("Cats", "is", "awesome")
  val product = Functor[List].fproduct(source)(_.length).toMap

  println(Functor[List].fproduct(source)(_.length))
  println(product.get("Cats").getOrElse(0))
  println(product.get("is").getOrElse(0))
  println(product.get("awesome").getOrElse(0))


  val listOpt = Functor[List] compose Functor[Option]
  println(listOpt.map(List(Some(1), None, Some(3)))(_ + 1))


  println(Apply[Option].tuple2(Some(1), Some(2)))

}
