package org.hinz.euler

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

object Solution5 {

  def div(seq:List[Int],n:Int):Boolean = {
    for(j <- seq if n < j || n % j != 0) return false
    return true
  }

  def calc(seq:List[Int], x:Int = 0):Int = 
    if (div(seq, x)) x
    else calc(seq,x+20)

  def run = println(calc((11 to 20).toList))
}
