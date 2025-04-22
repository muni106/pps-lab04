package tasks.adts

/*  Exercise 1: 
 *  Complete the implementation of ComplexADT trait below, so that it passes
 *  the test in ComplexTest.
 */

object Ex1ComplexNumbers:

  trait ComplexADT:
    type Complex
    def complex(re: Double, im: Double): Complex
    extension (complex: Complex)
      def re(): Double
      def im(): Double
      def sum(other: Complex): Complex
      def subtract(other: Complex): Complex
      def asString(): String

  object BasicComplexADT extends ComplexADT:

    // Change assignment below: should probably define a case class and use it?
    case class ComplexNumber(re: Double, im: Double)
    type Complex = ComplexNumber
    def complex(re: Double, im: Double): Complex = ComplexNumber(re, im)
    extension (complex: Complex)
      def re(): Double = complex.re
      def im(): Double = complex.im
      def sum(other: Complex): Complex = ComplexNumber(other.re + complex.re, other.im + complex.im)
      def subtract(other: Complex): Complex = ComplexNumber(complex.re - other.re, complex.im - other.im)
      def asString(): String = (complex.re, complex.im) match
        case (re, im) if im < 0 && re != 0 => re + " - " + im.abs + "i"
        case (re, im) if im == 0 => re.toString
        case (re, im) if re == 0 && im < 0 => im + "i"
        case (re, im) if re == 0 => im + "i"
        case _ => re + " + " + im + "i"
