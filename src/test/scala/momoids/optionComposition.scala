package momoids

import monoids._
object optionComposition extends App {
  def compose[Int](options:Option[Int] *)(implicit monoid:Monoid[Option[Int]])=
    options.foldLeft(monoid.zero)(monoid.op(_, _))

  def testAdd = {
      implicit val m = optionMonoid[Int](intAdditionMonoid)
      val x = compose(Option(1), Option(2), None, Option(4))
      println(x)
  }

  def testProduct = {
    implicit val m = optionMonoid[Int](intMultiplicationMonoid)
    val x = compose(Option(1), Option(2), None, Option(4))
    println(x)
  }
  testAdd
  testProduct

}
