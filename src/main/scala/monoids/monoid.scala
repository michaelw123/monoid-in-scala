package monoids

object monoid extends App {
  trait Monoid[A] {
    def zero: A
    def op(a1: A, a2: A): A
  }
  case class MonoidInstance[A](z:A, f: (A,A) => A) extends Monoid[A] {
    override def zero = z
    override def op(a:A, b:A) = f(a,b)
  }
}
