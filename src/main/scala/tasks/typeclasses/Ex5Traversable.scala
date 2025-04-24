package u04lab
import u03.Sequences.*
import Sequence.*
import u03.Optionals.Optional

/*  Exercise 5: 
 *  - Generalise by ad-hoc polymorphism logAll, such that:
 *  -- it can be called on Sequences but also on Optional, or others... 
 *  -- it does not necessarily call log, but any function with analogous type
 *  - Hint: introduce a type class Traversable[T[_]]], capturing the ability of calling a
 *    "consumer function" on all elements (with type A) of a datastructure T[A] 
 *    Note Traversable is a 2-kinded trait (similar to Filterable, or Monad)
 *  - Write givens for Traversable[Optional] and Traversable[Sequence]
 *  - Show you can use the generalisation of logAll to:
 *  -- log all elements of an Optional, or of a Traversable
 *  -- println(_) all elements of an Optional, or of a Traversable
 */

object Ex5Traversable:
  trait Traversable[F[_]]:
    def foreach[A](fa: F[A])(f: A => Unit): Unit

  def log[A](a: A): Unit = println("The next element is: " + a)

  def logAll[A](seq: Sequence[A]): Unit = seq match
    case Cons(h, t) => log(h); logAll(t)
    case _ => ()


//  @main def tryTraversables =
//    val seq = Cons(1, Cons(2, Cons(3, Nil())))
//    val opt = Optional.Just(42)
//    val empty = Optional.Empty()
//
//    logAll(seq)  // logs all elements in sequence
//    logAll(opt)  // logs the single element
//
//    forEachDo(seq)(println)   // prints 1 2 3
//    forEachDo(opt)(println)   // prints 42
//    forEachDo(empty)(println) // prints nothing