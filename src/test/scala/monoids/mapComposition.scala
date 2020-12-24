package monoids

object mapComposition extends App {
  def merge[K, V](maps:Map[K, V] *)(implicit monoid: Monoid[Map[K, V]]):Map[K, V] = {
    maps.foldLeft(monoid.zero)(monoid.op(_, _))
  }
  import monoidInstance.mapMonoid
  val x = merge(Map("a" -> 1, "b" -> 2), Map("a" -> 3, "b" -> 4), Map("a" -> 5, "c" -> 4))
  println(x)
}
