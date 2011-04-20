package org.hinz.euler

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

   Find the sum of all the primes below two million.
 */
object Solution10 {
  
  def prime(x:Long,k:Long = 2):Boolean =
    if (k > math.sqrt(x)) return true
    else return x % k != 0 && prime(x,k+1)

  def n(i: Long):Stream[Long] = Stream.cons(i, n(i+1))
  def primes = n(2).filter(prime(_))

  def run = println(primes.takeWhile(_ < 2000000).reduceLeft(_+_))

}
