package monoids

object mapComposition extends App {
  def merge[String, Int](maps:Map[String, Int] *)(implicit monoid: Monoid[Map[String, Int]]):Map[String, Int] = {
    maps.foldLeft(monoid.zero)(monoid.op(_, _))
  }
  implicit val stringIntMapMonoid = mapMonoid[String, Int]
  val x = merge(Map("a" -> 1, "b" -> 2), Map("a" -> 3, "b" -> 4), Map("a" -> 5, "c" -> 4))
  println(x)
}
