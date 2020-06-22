package GeeksForGeeks

object RemoveDuplicates extends App {

  def unique(str: String) = str.toSet.mkString("")

  println(unique("bananas"))

}
