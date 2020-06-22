package SortingAlgo

object QuickSort extends App {


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


//  def mergeSort(input: List[Int]) = {
//    def sort(left: List[Int], right: List[Int], merged:List[Int]) = left match {
//      case Nil => result
//      case h :: t =>
//
//
//    }
//  }

    def quickSort(input: List[Int]) : List[Int] = {
      if(input.size == 0) input
      else{
        val pivot = input(input.length / 2)
        quickSort(input.filter(_ < pivot)) ::: input.filter(_ == pivot) ::: quickSort(input.filter(_ > pivot))
      }
    }

    def quickSort1(input: List[Int]) : List[Int] = {
        if(input.size == 0) input
        else{
            val pivot = input(input.length / 2)
            quickSort1(input.filter(_ > pivot)) ::: input.filter(_ == pivot) ::: quickSort1(input.filter(_ < pivot))
        }
    }

//    def mergeSort(input: List[Int]) : List[Int] = {
//      if(input.size == 0) input
//      else{
//        val (left, right) = input.splitAt(input.length / 2)
//          left.filter(mergeSort(left.last) < mergeSort(left.last)) ::: mergeSort(right.filter(_ > right.last))
//      }
//    }


    //println(quickSort(List(4,3,5,1,9)))
    println(quickSort1(List(4,3,5,1,9)))
    //println(mergeSort(List(4,3,5,1,9)))

}
