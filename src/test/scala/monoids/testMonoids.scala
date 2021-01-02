package monoids

object testMonoids extends App {
  def stringConcat(strings:Seq[String])(implicit m:Monoid[String]) =
    strings.foldLeft(m.zero)(m.op(_, _))

  def booleanComposition(bools:Seq[Boolean])(implicit m:Monoid[Boolean]) =
    bools.foldLeft(m.zero)(m.op(_, _))

  def intAddition(ints:Seq[Int])(implicit m:Monoid[Int]) = {
    ints.foldLeft(m.zero)(m.op(_, _))
  }

  def optionCompose[A](options:Option[A] *) (implicit m:Monoid[Option[A]]) =
    options.foldLeft(m.zero)(m.op(_, _))


  def mapMerge[K, V](maps:Map[K, V] *)(implicit monoid: Monoid[Map[K, V]]):Map[K, V] = {
    maps.foldLeft(monoid.zero)(monoid.op(_, _))
  }
  def setMerge[A] (sets:Set[A] *)(implicit m:Monoid[Set[A]]):Set[A] = {
    sets.foldLeft(m.zero)(m.op(_, _))
  }
  def testOrComposition = {
    import monoidInstance.booleanOrMonoid
    val x = booleanComposition(Seq(true, false, true))

    println(x)
  }

  def testAndComposition = {
    import monoidInstance.booleanAndMonoid
    val x = booleanComposition(Seq(true, false, true))
    println(x)
  }
  def testString = {
    import monoidInstance.stringConcatMonoid
    val x = stringConcat(Seq("a", "b", "c"))
    println(x)
  }
  def testIntAddition = {
    import monoidInstance.intAdditionMonoid
    val intSeq=Seq(1,2,3,4,5)
    println(intAddition(intSeq))
  }
  def testOption = {
    import monoidInstance.{optionMonoid, intAdditionMonoid, stringConcatMonoid}

    println(optionCompose(Some(1), None, Some(2)))
    println(optionCompose(Some("a"), None, Some("b")))
  }
  def testMapMerge: Unit = {
    import monoidInstance.mapMonoid
    val x = mapMerge(Map("a" -> 1, "b" -> 2), Map("a" -> 3, "b" -> 4), Map("a" -> 5, "c" -> 4))
    println(x)
  }
  def testSetMerge = {
    import monoidInstance.setMonoid
    val x = setMerge(Set("a", "b"), Set("a", "c"))
    println(x)

    val y = setMerge(Set(1, 2), Set(1, 3))
    println(y)
  }
  testString
  testIntAddition
  testOrComposition
  testAndComposition
  testOption
  testMapMerge
  testSetMerge
}
