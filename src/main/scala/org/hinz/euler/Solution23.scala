package org.hinz.euler

import scala.annotation.tailrec

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/

object Solution23 {

  val max = 28123
  val abunds = (12 to max).filter(k => divsum(k) > k).toSet 
 
  @tailrec
  def divsum(k: Int, sum: Int = 1, cur: Int = 2):Int =
    if (cur > math.sqrt(k)) sum
    else if (cur == math.sqrt(k)) divsum(k, sum + cur, cur + 1)
    else if (k % cur == 0) divsum(k, sum + cur + k / cur, cur + 1)
    else divsum(k, sum, cur + 1) 
    
  val sums = abunds.flatMap(x => abunds.map(_ + x)).filter(_ <= max)
  val soln = (1.to(max)).toSet -- sums

  def run = println(soln.reduceLeft(_+_))
}
