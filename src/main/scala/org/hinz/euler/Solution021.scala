package org.hinz.euler

import scala.annotation.tailrec

/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/

object Solution021 {

  @tailrec
  def d(k: Int, sum: Int = 1, cur: Int = 2):Int =
    if (cur > math.sqrt(k)) sum
    else if (cur == math.sqrt(k)) d(k, sum + cur, cur + 1)
    else if (k % cur == 0) d(k, sum + cur + k / cur, cur + 1)
    else d(k, sum, cur + 1) 

  def am(k: Int) = {
    val b = d(k)
    b != k && d(b) == k
  }

  def run = println(2.to(10000).filter(am(_)).reduceLeft(_+_))
}
