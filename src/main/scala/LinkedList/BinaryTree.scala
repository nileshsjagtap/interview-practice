package LinkedList

trait Tree[A]

case class Leaf[A](value:A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def size(xs: Tree[Int]):Int = xs match {
    case Leaf(v) => 1
    case Branch(l, r) => size(l) + size(r) + 1
  }

  def maximum(t: Tree[Int]):Int = t match {
    case Leaf(v) => v
    case Branch(l, r) => maximum(l) max maximum(r)
  }

  def depth(t: Tree[Int]): Int = t match {
    case Leaf(v) => 1
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }

  def map[A,B](t:Tree[A])(f: A => B): Tree[B] = t match {
    case Leaf(v) => Leaf(f(v))
    case Branch(l,r) => Branch(map(l)(f), map(r)(f))
  }

  def insert(value:Int, t:Tree[Int]): Tree[Int] = t match {
    case Leaf(v) => Branch(Leaf(v), Leaf(value))
    case Branch(l, r) => Branch(insert(value, l), insert(value, r))
  }
}

object xyz extends App {

  println(Tree.size(Branch(Branch(Leaf(2), Leaf(3)), Branch(Leaf(5), Leaf(6)))))
  println(Tree.maximum(Branch(Branch(Leaf(2), Leaf(3)), Branch(Leaf(5), Leaf(6)))))
  println(Tree.depth(Branch(Branch(Leaf(2), Leaf(3)), Branch(Leaf(5), Branch(Leaf(7), Leaf(6))))))
  println(Tree.insert(10,Branch(Branch(Leaf(2), Leaf(3)), Branch(Leaf(5), Branch(Leaf(7), Leaf(6))))))


}