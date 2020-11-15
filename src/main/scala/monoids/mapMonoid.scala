package monoids

object mapMonoid {
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
}
