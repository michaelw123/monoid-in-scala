package object monoids {
  trait Monoid[A] {
    def zero: A

    def op(a1: A, a2: A): A
  }

  case class MonoidInstance[A](z: A, f: (A, A) => A) extends Monoid[A] {
    override def zero = z
    override def op(a: A, b: A) = f(a, b)
  }

  implicit val intAdditionMonoid = MonoidInstance[Int](0, _ + _)
  //implicit val intMultiplicationMonoid =  MonoidInstance[Int](1, _ * _)
}
