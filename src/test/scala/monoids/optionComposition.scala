package monoids

object optionComposition extends App {
  def compose[A](options:Option[A] *) (implicit m:Monoid[Option[A]]) =
    options.foldLeft(m.zero)(m.op(_, _))
  import monoidInstance.{optionMonoid, intAdditionMonoid, stringConcatMonoid}

  println(compose(Some(1), None, Some(2)))

  println(compose(Some("a"), None, Some("b")))

}
