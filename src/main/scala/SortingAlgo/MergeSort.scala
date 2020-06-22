package SortingAlgo

import scala.annotation.tailrec

object MergeSort extends App {


//  def merge(left:List[Int], right:List[Int]): List[Int] = {
//    val output = (0 until left.length + right.length).foldLeft(List[Int](), left, right) { (triple, _) =>
//      val (merged, leftRemaining, rightRemaining) = triple
//      (leftRemaining, rightRemaining) match {
//        case (Nil, r :: rTail) => (r :: merged, Nil, rTail)
//        case (l :: lTail, Nil) => (l :: merged, lTail, Nil)
//        case (l :: lTail, r :: rTail) if l < r => (l :: merged, lTail, rightRemaining)
//        case (l :: lTail, r :: rTail) => (r :: merged, leftRemaining, rTail)
//      }
//    }
//    output._1.reverse
//  }
//
//
//  def merge1(merged:List[Int], left:List[Int], right:List[Int]):List[Int] = (left, right) match{
//    case (Nil, r :: rTail) => merge1(r :: merged, Nil, rTail)
//    case (l :: lTail, Nil) => merge1(l :: merged, lTail, Nil)
//    case (l :: lTail, r :: rTail) if l < r => merge1(l :: merged, lTail, rTail)
//    case (l :: lTail, r :: rTail) => merge1(r :: merged, lTail, rTail)
//    case (Nil, Nil) => merged
//  }



  def mergeSort(input: List[Int]): List[Int] = {
    def sort(left: List[Int], right: List[Int], res : List[Int] = Nil) : List[Int] = (left, right) match {
      case (Nil, r::rTail) => (right ::: res).reverse
      case (l :: lTail, Nil) => (left ::: res).reverse
      case (l :: lTail, r :: rTail) if(l < r) => sort(lTail, right, l :: res)
      case (l :: lTail, r :: rTail) => sort(left, rTail, r :: res)
    }

//  def sort(right: List[Int], left: List[Int], res: List[Int] = Nil): List[Int] = (right, left) match{
//    case (Nil, l::lTail) => (left ::: res).reverse
//    case (r::rTail, Nil) => (right ::: res).reverse
//    case (r::rTail, l::lTail) if(l < r) => sort(rTail, left, r::res)
//    case (r::rTail, l::lTail) => sort(right, lTail, l::res)
//  }

  val size = input.length / 2
  if (size <= 0) input else {
    val (left, right) = input.splitAt(input.length / 2)
    sort(mergeSort(left), mergeSort(right))
  }

}


  def mergeSort1(l: List[Int]): List[Int] = {
    @tailrec
    def merger(l1: List[Int], l2: List[Int], res: List[Int] = Nil): List[Int] = (l1, l2) match {
      case (_, Nil) => (l1 ::: res).reverse
      case (Nil, _) => (l2 ::: res).reverse
      case (x :: t, y :: ts) => {
        println(s"x: $x, y: $y")
        if (y > x) {
          println(s"tail of l1: $t, l2: $l2, res: $res")
          merger(l1, ts, y :: res)
        } else {
          println(s"tail of l2: $ts, l2: $l1, res: $res")
          merger(t, l2, x :: res)
        }
      }
    }
    val size = l.length / 2
    if (size == 0) l else {
      val tuple = l.splitAt(size)
      merger(mergeSort1(tuple._1), mergeSort1(tuple._2))
    }
  }

  println(mergeSort(List(6,2,4,1,8,5,3)))

}
