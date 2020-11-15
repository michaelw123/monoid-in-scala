package momoids

object intComposition extends App {

  def addition(list:List[Int]) = {
    import monoids.intAdditionMonoid
    list.foldLeft(intAdditionMonoid.zero)(intAdditionMonoid.op(_, _))
  }

  val intList=List(1,2,3,4,5)
  println(addition(intList))

//  def multiplication(list:List[Int]) = {
//    import monoids.intMultiplicationMonoid
//    list.foldLeft(intMultiplicationMonoid.zero)(intMultiplicationMonoid.op(_, _))
//  }
//  println(multiplication(intList))
}
