package monoids

object mapMonoid {
//  trait Monoid[A] {
//    def zero: A
//    def op(a1: A, a2: A): A
//  }
//  case class MonoidInstance[A](z:A, f: (A,A) => A) extends Monoid[A] {
//    override def zero = z
//    override def op(a:A, b:A) = f(a,b)
//  }
//  object monoid {
//    implicit val intAdditionMonoid= MonoidInstance[Int](0, _ + _)
//
//    implicit def mapMonoid[K, V](implicit vm: Monoid[V]): Monoid[Map[K, V]] =
//      new Monoid[Map[K, V]] {
//        override final def op(m1: Map[K, V], m2: Map[K, V]): Map[K, V] =
//          (m1.keySet | m2.keySet).foldLeft(this.zero) {
//            case (acc, key) =>
//              acc + (key -> vm.op(
//                m1.getOrElse(key, default = vm.zero),
//                m2.getOrElse(key, default = vm.zero)
//              ))
//          }
//
//        override final val zero: Map[K, V] = Map.empty
//      }
//
//  }

  //Map('a' -> 1, 'b' -> 2) |+| Map('b' -> 3, 'c' -> 5)
}
