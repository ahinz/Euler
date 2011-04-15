package org.hinz.euler

object Solution4 {

  def mult = for(j <- 100 to 999; k <- 100 to 999) yield j*k
  def calc = mult.filter(pal(_)).toList.sortWith(_ > _)
  def pal(s:Int) = s.toString.reverse == s.toString

  def run = println(calc.head)

}
