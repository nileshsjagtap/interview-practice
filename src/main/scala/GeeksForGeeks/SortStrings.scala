package GeeksForGeeks

object SortStrings extends App{



  def call() = {
    val numberOfInputString = scala.io.StdIn.readLine()
    for (i <- 0 until numberOfInputString.toInt) {
      println()
      sortStrings(scala.io.StdIn.readLine().split(" ").toList).mkString(" ").map(println)
    }
  }

  def sortStrings(str:List[String]): List[String] = {
    if (str.size == 0) str
    else{
      val pivot = str(str.size/2)
      sortStrings(str.filter(x =>  x.length < pivot.length)) ::: str.filter(y => y.length == pivot.length) ::: sortStrings(str.filter(x =>  x.length > pivot.length))
    }
  }

  def sortMultiple(strs: List[List[String]]) = {
    strs.map(x => sortStrings(x))
  }

  //println(sortStrings(List("ab", "cd", "e", "j", "asd", "ljffg", "df")))
  call()

}
