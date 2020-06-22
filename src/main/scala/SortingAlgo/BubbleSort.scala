package SortingAlgo

object BubbleSort extends App{



  def bubbleSort(inputList: List[Int]) : List[Int] = {
    def sort(inputList: List[Int], result: List[Int]) = inputList match {
      case Nil => result
      case h::t => bubble(inputList, Nil, result)
    }

    def bubble(inputList: List[Int], tempList: List[Int], result: List[Int]) : List[Int] = inputList match {
      case h1 :: h2 :: t => if(h1 > h2) bubble(h1::t, h2::tempList, result) else bubble(h2::t, h1::tempList, result)
      case h1 :: t => sort(tempList, h1 :: result)
    }

    sort(inputList, Nil)
  }



  println(bubbleSort(List(2,4,19,6,4)))

}
