package GeeksForGeeks

object kThArrayElement extends App{

  def getKElement(list:List[Int], start: Int, end:Int, kth: Int) = {
    list.sortWith(_ < _)(kth)
  }

  println(getKElement(List(3, 2, 5, 4, 7, 1, 9), 2,6,3))

}
