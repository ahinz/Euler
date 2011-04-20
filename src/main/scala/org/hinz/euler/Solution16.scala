package org.hinz.euler

object Solution16 {
    def run = println(BigInt(2).pow(1000).toString.map(_.toString.toInt).reduceLeft(_+_))
}
