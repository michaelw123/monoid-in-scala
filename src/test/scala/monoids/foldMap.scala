package monoids

object foldMap extends App {
  def foldMap[A, B](s:Seq[A], f: A => B)(implicit m:Monoid[B]):B = {
    s.length match {
      case 0 => m.zero
      case 1 => f(s.head)
      case _ => {
        val (l, r) = s.splitAt(s.length / 2)
        m.op(foldMap(l, f), foldMap(r, f))
      }
    }
  }
  def complicatedcomputation(x:Int) = x.toString
  val x = foldMap(List(1,2,3,4,5), complicatedcomputation)

  println(x)
}
