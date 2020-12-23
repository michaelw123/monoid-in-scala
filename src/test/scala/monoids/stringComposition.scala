package monoids

object stringComposition extends App{
  def contact(strings:Seq[String])(implicit m:Monoid[String]) =
    strings.foldLeft(m.zero)(m.op(_, _))

  import monoidInstance.stringConcatMonoid
  val x = contact(Seq("a", "b", "c"))

  println(x)
}
