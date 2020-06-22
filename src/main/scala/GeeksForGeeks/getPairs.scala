package GeeksForGeeks

object Run extends App {

//  val name = scala.io.StdIn.readLine()
//  val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList
  var count: Int = 0


  def getPairCount(input: List[Int]): List[Int] = {
    def sort(left: List[Int], right: List[Int], res : List[Int] = Nil) : List[Int] = (left, right) match {
      case (Nil, r::rTail) => (right ::: res).reverse
      case (l :: lTail, Nil) => (left ::: res).reverse
      case (l :: lTail, r :: rTail) if(l < r) => sort(lTail, right, l :: res)
      case (l :: lTail, r :: rTail) => count+=1; sort(left, rTail, r :: res)
    }

    val size = input.length / 2
    if (size <= 0) input else {
      val (left, right) = input.splitAt(input.length / 2)
      sort(getPairCount(left), getPairCount(right))
    }
  }

  def getCount(input:List[Int], start:Int, end:Int):Option[Int] ={
    def sort(input:List[Int], start:Int, end:Int, count:Int):Option[Int] = (start+end)/2 match {
      case _ if(start < end) => None
      case mid if (input(start) > input(start + 1)) => sort(input, start + 1, end, count + 1)
      case mid if (input(start) < input(start + 1)) => sort(input, start + 1, end, count)
      case mid => Some(count)
    }
    sort(input, start, end, 0)
  }

  println(getCount(List(1,4,3,2,5), 0 , 4))

}
