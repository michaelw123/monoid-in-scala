import monoids.Monoid

package object monoidInstance {
  case class MonoidInstance[A](z: A, f: (A, A) => A) extends Monoid[A] {
    override def zero = z
    override def op(a: A, b: A) = f(a, b)
  }
  implicit val intAdditionMonoid = MonoidInstance[Int](0, _ + _)
  implicit val stringConcatMonoid =  MonoidInstance[String]("", _ + _)
  implicit val booleanOrMonoid = MonoidInstance[Boolean](false, _ || _)
  implicit val booleanAndMonoid = MonoidInstance[Boolean](true, _ && _)
  implicit def setMonoid[A] = MonoidInstance[Set[A]](Set.empty[A], _ ++ _)
  implicit def listMonoid[A] = MonoidInstance[List[A]](Nil, _ ++ _)
  implicit def mapMonoid[K, V] = MonoidInstance[Map[K,V]](Map.empty[K, V], _ ++ _)
  implicit def functionCompositionMonoid[A,B](B: Monoid[B]): Monoid[A => B] = new Monoid[A => B] {
    def op(f: A => B, g: A => B) = a => B.op(f(a), g(a))
    val zero: A => B = a => B.zero
  }
  //implicit def maxMonoid = MonoidInstance[Int](Int.MinValue, math.max(_, _))
  //implicit def minMonoid = MonoidInstance[Int](Int.MaxValue, math.min(_, _))


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

  //  implicit def mapMonoid[K, V](implicit vm: Monoid[V]): Monoid[Map[K, V]] = {
  //    new Monoid[Map[K, V]] {
  //      override final def op(m1: Map[K, V], m2: Map[K, V]): Map[K, V] =
  //        (m1.keySet | m2.keySet).foldLeft(this.zero) {
  //          case (acc, key) =>
  //            acc + (key -> vm.op(
  //              m1.getOrElse(key, default = vm.zero),
  //              m2.getOrElse(key, default = vm.zero)
  //            ))
  //        }
  //
  //      override final val zero: Map[K, V] = Map.empty
  //    }
  //  }
  //implicit def numericMaxMonoid[A <: Numeric]

  //      trait Monoid2[F[_], A] {
  //        def zero:F[A]
  //        def op(a1:F[A], a2:F[A]):F[A]
  //      }

}
