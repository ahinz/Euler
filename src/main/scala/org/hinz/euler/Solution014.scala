package org.hinz.euler
import scala.collection.immutable.HashMap

import scala.annotation.tailrec

/**
The following iterative sequence is defined for the set of positive integers:

n  n/2 (n is even)
n  3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13  40  20  10  5  16  8  4  2  1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?
*/

object Solution14 {

  def nlen2(s:Long):Long = nlen2(s,1) 
  def nlen2(s:Long, cnt:Long):Long = 
    if (s == 1) cnt
    else nlen2(if (s % 2 == 0) s / 2 else 3*s + 1, cnt + 1)

  def n(s:Long):Stream[Long] = Stream.cons(s, n(if (s % 2 == 0) s / 2 else 3*s + 1))
  def l(s:Long) = n(s).takeWhile(_ != 1).length + 1 
   
  def run = println((for(j <- 13 to 999999) yield((l(j),j))).max)
}
