package GeeksForGeeks

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.global

object MapOp extends App{

  val mapp = Map('a' -> 10, 'b' -> 20, 'c' -> 30)
  val list = List(1,2,3,4)
  println(mapp.toList.sortWith(_._2 > _._2))


//  for{
//    a <- Future.successful(4)
//    b <- Future.successful(5)
//  }yield println(a+b)
  val p1 = Person(1,"a")
  val p2 = Person(2,"b")
  val p3 = Person(3,"c")
  val p4 = Person(4,"c")
  val l = List(p1,p2,p3)

  println(l.groupBy(_.name))





}
case class Person(age:Int, name: String)