package monoids

object intComposition extends App {
  def addition(ints:Seq[Int])(implicit m:Monoid[Int]) = {
    ints.foldLeft(m.zero)(m.op(_, _))
  }
  import monoidInstance.intAdditionMonoid
  val intSeq=Seq(1,2,3,4,5)
  println(addition(intSeq))

//  def max(ints:Seq[Int]):Int = {
//    def maxMonoid = MonoidInstance[Int](Int.MinValue, math.max(_, _))
//    ints.foldLeft(maxMonoid.zero)(maxMonoid.op(_, _))
//  }
//  println(max(List(1,2,3)))
//
//  def min(list:List[Int])(implicit m:Monoid[Int]):Int = {
//    def minMonoid = MonoidInstance[Int](Int.MaxValue, math.min(_, _))
//    list.foldLeft(minMonoid.zero)(minMonoid.op(_, _))
//  }
//  println(min(List(1,2,3)))
}
