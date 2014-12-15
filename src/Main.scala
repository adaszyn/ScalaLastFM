/**
 * Created by Arkadiusz on 2014-12-12.
 */
import Graph._
import Music._
object Main {
  def main (args: Array[String]) {

    var g = new Graph()
    var ar2 = new Artist("Cher")
    ar2.getInfo()
    println(ar2.getSimilars(10))
  }
}
