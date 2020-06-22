package Wen

class Addition {


  def operation(num1:Int)(num2:Int)(f: (Int, Int) => Int) = f(num1,num2)

  def add(num1: Int, num2:Int)  = num1 + num2

//  println(operation(2)(_)(add))

  val s = List(1,2,3,4)




}
