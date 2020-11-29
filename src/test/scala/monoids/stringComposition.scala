package monoids

object stringComposition extends App{
  def contact(strings:List[String]) =
    strings.foldLeft(stringConcatMonoid.zero)(stringConcatMonoid.op(_, _))

  val x = contact(List("a", "b", "c"))

  println(x)
}
