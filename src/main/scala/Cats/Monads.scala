package Cats

import cats.Monad
import cats.implicits._

object Monads extends App {

  println(Monad[Option].ifM(Option(false))(Option("truthy"), Option("falsy")))
  println(Monad[List].ifM(List(true, false, true))(List(1, 2), List(3, 4)))

}
