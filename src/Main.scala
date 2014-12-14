/**
 * Created by Arkadiusz on 2014-12-12.
 */
import Graph._
import Music._
object Main {
  def main (args: Array[String]) {

    var g = new Graph()
    var ar1 = new Artist("Scorpions")
    var ar2 = new Artist("50 cent")
    var e = ar1.connect(ar2)
    print(e)
  }
}
