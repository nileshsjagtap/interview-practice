package SortingAlgo

object ReverseList extends App{


  def reverse(list : List[Int]): List[Int] = {
    def rev(list: List[Int], res: List[Int]): List[Int] = list match {
      case Nil => res
      case h :: t => rev(t, h :: res)
    }

    rev(list, Nil)
  }


  def fibonacci(number: Int):Int = {
    def fib(number: Int, prev: Int, next: Int):Int = number match {
      case 0 => prev
      case 1 => next
      case _ => fib(number-1, next, prev+next)
    }
    fib(number, 0, 1)
  }

  println(fibonacci(4))

  println(reverse(List(5,4,3,2,1)))

}
