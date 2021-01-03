package monoids

trait Foldable[F[_]]  {
    def fold[A](fa: F[A])(implicit A: Monoid[A]): A
    def foldMap[A, B](s: F[A])(f: A => B)(implicit m: Monoid[B]): B
}
object Foldable {
  def apply[F[_]](implicit instance: Foldable[F]): Foldable[F] = instance
  implicit val listFoldable:Foldable[List] = new Foldable[List] {
      override def fold[A](fa: List[A])(implicit m: Monoid[A]): A = {
        fa.foldLeft(m.zero)(m.op)
      }
      override def foldMap[A, B](s: List[A])(f: A => B)(implicit m: Monoid[B]): B  = {
      fold(s.map(f))(m)
    }


  }

}

