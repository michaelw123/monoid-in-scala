package monoids


import scala.collection.parallel.immutable.ParSeq
object parallel extends App {
  def parallel[A](s:ParSeq[A])(implicit m:Monoid[A]):A = s.length match {
    case 0 => m.zero
    case 1 => s.head
    case _ => {
      val (l, r) = s.splitAt(s.length / 2)
      m.op(parallel(l), parallel(r))
    }
  }

//  val x = parallel(List(1,2,3,4,5,6).par)
//  println(x)
//  val y =  parallel(List("1", "2", "3", "4","5","6").par)
//  println(y)

}
