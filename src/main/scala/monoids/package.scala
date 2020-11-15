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

  implicit def optionMonoid[A](implicit m:Monoid[A]): Monoid[Option[A]] =
    new Monoid[Option[A]] {
        def zero:Option[A] = None
        def op(a1:Option[A], a2:Option[A]):Option[A] = (a1, a2) match {
          case (None, None) => None
          case (Some(_), None) => a1
          case (None, Some(_)) => a2
          case (Some(x), Some(y)) => Some(m.op(x, y))
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
//      trait Monoid2[F[_], A] {
//        def zero:F[A]
//        def op(a1:F[A], a2:F[A]):F[A]
//      }
  implicit def setMonoid[A] = MonoidInstance[Set[A]](Set.empty[A], _ ++ _)

}
