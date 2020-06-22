package Wen

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

case class Employee(name: String, age: Int)

object Employee extends App{

  val e1 = Employee("hello", 100);
  val e2 = Employee("hello", 100);
  e1 == e2

  val f = Future(List(2,4,6))

  val res = f.map(s => s.map(_*2))

}
////table - Employee , columns - name , age
//"a"   30
//"b"   40
//"c"   50
//"a"   30