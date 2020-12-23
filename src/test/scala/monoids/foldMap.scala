package monoids

object foldMap extends App {
  def fold[A](s:Seq[A]) (implicit m:Monoid[A]):A =
    s.length match {
      case 0 => m.zero
      case 1 => s.head
      case _ => {
        val (l, r) = s.splitAt(s.length / 2)
        m.op(fold(l), fold(r))
      }
    }
  def foldMap[A, B](s:Seq[A], f: A => B)(implicit m:Monoid[A]):B = {
    f(fold(s)(m))
  }
  def mapFold[A,B](s:Seq[A], f: A => B)(implicit m:Monoid[B]):B = {
    fold(s.map(f))(m)
  }
  def complicatedcomputation(x:Int) = x.toString

//  val x = foldMap(List(1,2,3,4,5), complicatedcomputation)
//
//  println(x)
//  def length(s:String) = s.length
//  val l = foldMap(List("a", "bb", "ccc"), length)
//
//  println(l)
//
//  val l1 = mapFold(List("a", "bb", "ccc"), length)
//  println(l1)
}
