package momoids

import monoids._
object intComposition extends App {
  def addition(list:List[Int]) = {
    list.foldLeft(intAdditionMonoid.zero)(intAdditionMonoid.op(_, _))
  }
  val intList=List(1,2,3,4,5)
  println(addition(intList))

  def multiplication(list:List[Int]) = {
    list.foldLeft(intMultiplicationMonoid.zero)(intMultiplicationMonoid.op(_, _))
  }
  println(multiplication(intList))
}
