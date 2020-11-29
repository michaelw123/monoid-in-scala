package monoids

object intComposition extends App {
  def addition(list:List[Int]) = {
    list.foldLeft(intAdditionMonoid.zero)(intAdditionMonoid.op(_, _))
  }
  val intList=List(1,2,3,4,5)
  println(addition(intList))

  def max(list:List[Int]):Int = {
    def maxMonoid = MonoidInstance[Int](Int.MinValue, math.max(_, _))
    list.foldLeft(maxMonoid.zero)(maxMonoid.op(_, _))
  }
  println(max(List(1,2,3)))

  def min(list:List[Int]):Int = {
    def minMonoid = MonoidInstance[Int](Int.MaxValue, math.min(_, _))
    list.foldLeft(minMonoid.zero)(minMonoid.op(_, _))
  }
  println(min(List(1,2,3)))
}
