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
  implicit val intMultiplicationMonoid =  MonoidInstance[Int](1, _ * _)

  implicit val optionMonoid = new Monoid[Option[Int]] {
        def zero:Option[Int] = None
        def op(a1:Option[Int], a2:Option[Int]) = (a1, a2) match {
          case (None, None) => None
          case (Some(_), None) => a1
          case (None, Some(_)) => a2
          //case (Some(x), Some(y)) => a1 zip a2
        }
  }

  implicit def mapMonoid[K, V](implicit vm: Monoid[V]): Monoid[Map[K, V]] =
    new Monoid[Map[K, V]] {
      override final def op(m1: Map[K, V], m2: Map[K, V]): Map[K, V] =
        (m1.keySet | m2.keySet).foldLeft(this.zero) {
          case (acc, key) =>
            acc + (key -> vm.op(
              m1.getOrElse(key, default = vm.zero),
              m2.getOrElse(key, default = vm.zero)
            ))
        }

      override final val zero: Map[K, V] = Map.empty
    }
  //    implicit val optionMonoid = new Monoid[Option[Int]] {
  //      def zero:Option[Int] = None
  //      def op(a1:Option[Int], a2:Option[Int]) = (a1, a2) match {
  //        case (None, None) => None
  //        case (Some(_), None) => a1
  //        case (None, Some(_)) => a2
  //        //case (Some(x), Some(y)) => a1 zip a2
  //      }
  //    }
  //    trait Monoid2[F[_], A] {
  //      def zero:F[A]
  //      def op(a1:F[A], a2:F[A]):F[A]
  //    }
  //    trait SetMonoid[A] extends Monoid2[Set[A], A]{
  //      def zero = Set.empty[A]
  //      def op(a1:Set[A], a2:Set[A]):Set[A] = a1 ++ a2
  //    }
}
