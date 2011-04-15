package org.hinz.euler

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10001st prime number?
*/

object Solution7 {

  def prime(x:Int,k:Int = 2):Boolean =
    if (k > math.sqrt(x)) return true
    else return x % k != 0 && prime(x,k+1)

  def nextp(s:Int):Int =
    if (prime(s + 1)) s + 1
    else return nextp(s + 1)

  def calc = 1.to(10001).foldLeft(1){ (x:Int,y:Int) => nextp(x) }

  def run = println(calc)

}
