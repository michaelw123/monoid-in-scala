package monoids



object monoid extends App {

//  trait Monoid[A] {
//    def zero: A
//
//    def op(a1: A, a2: A): A
//  }
//
//  case class MonoidInstance[A](z: A, f: (A, A) => A) extends Monoid[A] {
//    override def zero = z
//    override def op(a: A, b: A) = f(a, b)
//  }
//
//    implicit val intMultiplicationMonoid = new Monoid[Int] {
//      def zero:Int = 1
//      def op(a1:Int, a2:Int) = a1 * a2
//    }
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

//  val intList=List(1,2,3)
//
// val x = intList.foldLeft(intAdditionMonoid.zero)(intAdditionMonoid.op(_, _))
//  println(x)
}

