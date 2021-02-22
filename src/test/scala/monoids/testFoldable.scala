package monoids
import monoids.Foldable._


object testFoldable extends App {

  def testFoldableInt = {
    import monoidInstance.intAdditionMonoid
    println(Foldable[List].fold(List(1, 2, 3)))
  }
  def testFoldableString = {
    import monoidInstance.stringConcatMonoid
    println(Foldable[List].fold(List("how", "are", "you")))
  }
  def testFoldableMap = {
    import monoidInstance.mapMonoid
    println(Foldable[List].fold(List(
      Map("1" -> 1, "2" -> 2, "3" -> 3),
      Map("1" -> 100, "2" -> 2, "4" -> 4))))
  }
  def testFoldMap = {
    import monoidInstance.intAdditionMonoid
    val a = Foldable[List].foldMap(List("aaa", "bbb", "ccc"))(_.length)
    println(a)
  }

  testFoldableInt
  testFoldableString
  testFoldableMap

  testFoldMap


}
