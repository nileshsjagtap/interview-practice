package GeeksForGeeks

object SubStringSearch extends App {


  def search(s1: String, s2: String):Boolean =   {
     if(s1.isEmpty || s2.isEmpty) false
     else if(s2.startsWith(s1)) true
     else search(s1, s2.substring(1))
  }

  println(search("Nij", "Nilesh"))

}
