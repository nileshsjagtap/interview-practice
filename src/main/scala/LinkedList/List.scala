package LinkedList

trait List[+A]

case object Nil extends List[Nothing]
case class Cons[A](head: A, tail: List[A]) extends List[A]


object List {

  def add(xs: List[Int]):Int = xs match {
    case Nil => 0
    case Cons(x, t) => x + add(t)
  }

  def apply[A](xs: A*):List[A] =  {
    if(xs.isEmpty) Nil
    else Cons(xs.head, apply(xs.tail: _*))
  }

  def tail(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case Cons(_, t) => t
  }

  def setHead(xs: List[Int], newHead:Int) = xs match {
    case Nil => Cons(newHead, Nil)
    case Cons(h, t) => Cons(newHead,xs)
  }

  def append(a1:List[Int], a2: List[Int]):List[Int] = a1 match {
    case Nil => a2
    case Cons(h,t) => Cons(h, append(t, a2))
  }

  def init(xs:List[Int], newList:List[Int]):List[Int] = xs match {
    case Nil => newList
    case Cons(h,Cons(h1,t)) => init(t, Cons(h, Cons(h1,Nil)))
    case Cons(h,t) => newList
  }

}

object abcd extends App {

  println(List.setHead(List(1,2,3) , 5))
  println(List.tail(List(1,2,3)))
  println(List.init(List(1,2,3), Nil))

}
