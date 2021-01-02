package monoids
import monoids.Foldable._


object testFold extends App {

  def testFoldableInt = {
    import monoidInstance.intAdditionMonoid
    println(Foldable[List].fold(List(1, 2, 3)))
  }
  def testFoldableString = {
    import monoidInstance.stringConcatMonoid
    println(Foldable[List].fold(List("a", "b", "c")))
  }
  def testFoldableMap = {
    import monoidInstance.mapMonoid
    println(Foldable[List].fold(List(
      Map("1" -> 1, "2" -> 2, "3" -> 3),
      Map("1" -> 100, "2" -> 2, "4" -> 4))))
  }

  
  testFoldableInt
  testFoldableString
  testFoldableMap


}
