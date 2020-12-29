package monoids

trait Foldable[F[_]]  {
    def fold[A](fa: F[A])(implicit A: Monoid[A]): A
  }
object Foldable {
  def apply[F[_]](implicit instance: Foldable[F]): Foldable[F] = instance
  implicit val listFold:Foldable[List] = new Foldable[List] {
      override def fold[A](fa: List[A])(implicit m: Monoid[A]): A =
        fa.foldLeft(m.zero)(m.op)
    }

}

