package monoids

object folding extends App {
  trait Fold[I, O] {
    type M
    def m: Monoid[M]

    def tally: I => M
    def summarize: M => O
  }
  object Fold {
    def apply[I, O, _M](_m: Monoid[_M])(
      _tally: I => _M, _summarize: _M => O): Fold[I, O] = new Fold[I, O] {
      override type M = _M
      override def m = _m
      override def tally = _tally
      override def summarize = _summarize
    }
  }
  def fold[I, O](input: Seq[I])(f: Fold[I, O]): O = {
    val reduced = input.foldLeft(f.m.zero) {
      case (a, i) => f.m.op(a, f.tally(i))
    }
    f.summarize(reduced)
  }
  def sum[M](implicit m: Monoid[M]): Fold[M, M] = Fold(m)(identity, identity)

  //println(fold(1 to 10)(sum))

  println(fold(List("a", "b", "c"))(sum))

  case class Average[A](numerator: A, denominator: Int)
  implicit def averageMonoid[A: Numeric] = new Monoid[Average[A]] {
    override def zero = Average(implicitly[Numeric[A]].zero, 0)
    override def op(l: Average[A], r: Average[A]) = Average(
      implicitly[Numeric[A]].plus(l.numerator, r.numerator),
      l.denominator+r.denominator)
  }
  def average[A: Numeric]: Fold[A, Double] = Fold(averageMonoid)(
    Average[A](_, 1),
    a => implicitly[Numeric[A]].toDouble(a.numerator) / a.denominator)

  println(fold(1 to 10)(average))

}
