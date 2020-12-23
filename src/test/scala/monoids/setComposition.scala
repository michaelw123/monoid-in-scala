package monoids

object setComposition extends App {
  def merge[A] (sets:Set[A] *)(implicit m:Monoid[Set[A]]):Set[A] = {
    sets.foldLeft(m.zero)(m.op(_, _))
  }
  import monoidInstance.setMonoid
  val x = merge(Set("a", "b"), Set("a", "c"))
  println(x)

  val y = merge(Set(1, 2), Set(1, 3))
  println(y)

}
