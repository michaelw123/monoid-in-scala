package monoids

object foldable {

  trait Foldable[F[_]] extends {
    def foldLeft[A, B](fa: F[A], b: B)(f: (B, A) => B): B
    def fold[A](fa: F[A])(implicit A: Monoid[A]): A =
        foldLeft(fa, A.zero) { (acc, a) =>
          A.op(acc, a)
        }
  }
  implicit def foldableList[A, B] = new Foldable[List] {
    def foldLeft[A, B](fa: List[A], b: B)(f: (B, A) => B): B = fa.foldLeft(b)((acc, a) =>f(acc, a))
  }
}
