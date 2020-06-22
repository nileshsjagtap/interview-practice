package SearchingAlgo

object BinarySearch extends App{

  def binarySearch(list: List[Int], target:Int) = {
    def search(low:Int, high:Int):Option[Int] = (high+low)/2 match{
      case _ if(high < low) => None
      case mid if(list(mid) > target) => search(low, mid-1)
      case mid if(list(mid) < target) => search(mid+1, high)
      case mid => Some(mid)
    }
    search(0, list.size-1)
  }




  println(binarySearch(List(1,2,3,4,5,6,7,8,9), 10))


}
