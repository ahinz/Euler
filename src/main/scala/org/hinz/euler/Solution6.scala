package org.hinz.euler

/**
 *The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

object Solution6 {

  def calc =  math.pow((1 to 100).reduceLeft(_+_),2) - (1 to 100).map(x => x*x).reduceLeft(_+_)


  def run = println(calc.toInt)
}
