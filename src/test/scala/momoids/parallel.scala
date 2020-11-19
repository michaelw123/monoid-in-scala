package momoids

import monoids._
object parallel extends App {
  def parallel[A](s:Seq[A])(implicit m:Monoid[A]):A = s.length match {
    case 0 => m.zero
    case 1 => s.head
    case _ => {
      val (l, r) = s.splitAt(s.length / 2)
      m.op(parallel(l), parallel(r))
    }
  }

  val x = parallel(List(1,2,3,4,5,6))
  println(x)
  val y =  parallel(List("1", "2", "3", "4","5","6"))
  println(y)

}
