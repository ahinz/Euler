package org.hinz.euler

case class Record(curMax: Int, path: List[Int]) {
  def merge(r: Record) = 
    if (r.curMax > curMax) r
    else this
}

object Solution018 extends Solution018{

  //val lst = List(List(8,5,9,3), List(2,4,6), List(7,4), List(3))
  override val lst = List(
    List(4,62,98,27,23,9,70,98,73,93,38,53,60,4,23),
    List(63,66,4,68,89,53,67,30,73,16,69,87,40,31),
    List(91,71,52,38,17,14,91,43,58,50,27,29,48),
    List(70,11,33,28,77,73,17,78,39,68,17,57),
    List(53,71,44,65,25,43,91,52,97,51,14),
    List(41,48,72,33,47,32,37,16,94,29),
    List(41,41,26,56,83,40,80,70,33),
    List(99,65,4,28,6,16,70,92),
    List(88,2,77,73,7,63,67),
    List(19,1,23,75,3,34),
    List(20,4,82,47,65),
    List(18,35,87,10),
    List(17,47,82),
    List(95,64),
    List(75))
}

abstract class Solution018 {

  val lst:List[List[Int]]

  implicit def lst2rec(lst: List[Int]):List[Record] = lst.map(a => Record(a,List(a)))

  def merge(recs:List[Record]) = 
    recs.zip(recs.tail).map(a => a._1.merge(a._2))

  def rollup(lst:List[Int], recs:List[Record]) =
    recs.zip(lst).map {
      case (Record(curMax,path),v) => Record(curMax + v, v :: path)
    }

  def mergelevels(lst:List[List[Int]]):List[Record] = mergelevels(lst.tail, lst.head)
  def mergelevels(lst:List[List[Int]], recs:List[Record]):List[Record] = lst match {
    case Nil => recs
    case h :: t => mergelevels(t, rollup(h, merge(recs)))
  }

  def run = println(mergelevels(lst)) 

}
