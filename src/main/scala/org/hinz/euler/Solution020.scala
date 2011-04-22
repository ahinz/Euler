package org.hinz.euler

/**
 * n! means n  (n  1)  ...  3  2  1

For example, 10! = 10  9  ...  3  2  1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
*/
object Solution020 {

  def f(i: BigInt):BigInt = 
    if (i == 1) 1
    else i * f(i - 1)

  def run = println(f(100).toString.map(_.toString.toInt).reduceLeft(_+_))
}
