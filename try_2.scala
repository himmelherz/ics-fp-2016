import scala.collection.mutable.ListBuffer
 
 object Main  {
   
   def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] =
  list.foldLeft(List[B]())(_ ++ f(_))
 
   def f(c:Int) = List(c*2,  c*0.2)
   
   def main(args: Array[String]) {
     val list = List( 1, 2, 3, 4)
     println(flatMap(list)(x => f(x)))
   }
   
 }
 import scala.collection.mutable.ListBuffer
 
 object Main  {
   
   def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] =
  list.foldLeft(List[B]())(_ ++ f(_))
 
   def f(c:Int) = List(c*2,  c*0.2)
   
   def main(args: Array[String]) {
     val list = List( 1, 2, 3, 4)
     println(flatMap(list)(res => f(res)))
   }
   
 }
 