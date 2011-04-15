package org.hinz.euler

/**
 A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

object Solution9 {


  def calc = for(a <- 1 to 1000; 
                 b <- a to 1000; 
                 c <- 1 to 1000 
                 if a*a + b*b == c*c &&
                    a + b + c == 1000) yield (a*b*c)

  def run = println(calc)

}
