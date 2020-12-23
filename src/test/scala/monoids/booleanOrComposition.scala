package monoids

object booleanOrComposition extends App {
  def booleanComposition(bools:Seq[Boolean])(implicit m:Monoid[Boolean]) =
    bools.foldLeft(m.zero)(m.op(_, _))

  def testOrComposition {
    import monoidInstance.booleanOrMonoid
    val x = booleanComposition(Seq(true, false, true))

    println(x)
  }

  def testAndComposition {
    import monoidInstance.booleanAndMonoid
    val x = booleanComposition(Seq(true, false, true))
    println(x)
  }
  testOrComposition
  testAndComposition

}
