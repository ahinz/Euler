package org.hinz.euler

import scala.annotation.tailrec

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

object Solution3 {

  @tailrec
  def prime(k:Long,p:Long = 2):Boolean =
    if (k == p) return true
    else if (k % p == 0) return false
    else return prime(k,p+1)

  /**
   * Largest prime factor has to be less than
   * sqrt(K)
   */
  def pfactors(k:Long) = pfactorsh(k,math.sqrt(k.doubleValue).toLong)
  
  @tailrec
  def pfactorsh(k:Long,f:Long):Long = 
     if (f > 0) {
        if (k % f == 0 && prime(f))
           return f
        else
           return pfactorsh(k,f-1)
     } else {
       return 1
     }
       
  def run = println(pfactors(600851475143L))
}
