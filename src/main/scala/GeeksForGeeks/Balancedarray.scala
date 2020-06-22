package GeeksForGeeks

object Balancedarray extends App{

  def balancedSum(arr: Array[Int]): Int = {


    def iterate(arr: Array[Int], larr: Array[Int], rarr: Array[Int], index: Int): Int = (larr.sum == rarr.sum) match {
      case true => index - 1
      case false => iterate(arr, arr.toList, arr.drop(index+1), index+1)
    }

    iterate(arr, Array(0), Array(1),0)
  }


  println(balancedSum(Array(1,2,3,3)))

}
