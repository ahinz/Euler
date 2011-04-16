package org.hinz.euler

import scala.annotation.tailrec

object Solution12 {

  def tri(v:Long=1,idx:Long=2):Stream[Long] = Stream.cons(v,tri(v + idx, idx + 1))

  def divcnt(v: Long):Long =
    divcnt(v, 0, 1, v)

  @tailrec
  def divcnt(v: Long, cnt:Long, cur:Long, limit:Long):Long = 
    if (cur >= limit) cnt * 2
    else if (v % cur == 0) divcnt(v, cnt + 1, cur + 1, v / cur)
    else divcnt(v, cnt, cur + 1, limit)

  def run = println(tri().filter(divcnt(_) > 500).take(1))

}
