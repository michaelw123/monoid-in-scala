package momoids
import monoids._

object setComposition extends App {
  def merge[String] (sets:Set[String] *):Set[String] = {
    sets.foldLeft(setMonoid[String].zero)(setMonoid[String].op(_, _))
  }

  val x = merge(Set("a", "b"), Set("a", "c"))

  println(x)
}
