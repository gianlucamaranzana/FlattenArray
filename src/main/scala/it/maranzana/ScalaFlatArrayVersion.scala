package it.maranzana

import scala.Console.out

trait ScalaFlatArray {

  protected final def toFlat(a: Seq[Any]): Seq[Int] =
    a.flatMap {
      case s: Int => Seq(s)
      case s: Seq[Any] => toFlat(s)
    }

}


object ScalaFlatArrayVersion extends ScalaFlatArray {

  implicit class ScalaFlatArrayVersion(val array: Seq[Any]) {
    def toFlattenArray: Seq[Any] = toFlat(array)
  }

  def test(): Unit = {

    out.println("SCALA: flatten an array of arbitrarily nested arrays of integers into a flat array of integers. e.g. [[1,2,[3]],4] -> [1,2,3,4].")

    val a = Seq(Seq(1,2,Seq(3)), 4, Seq(5,Seq(6,Seq(7,Seq(8,9)))))

    out.println(s"${ a.toFlattenArray }")

  }

}
