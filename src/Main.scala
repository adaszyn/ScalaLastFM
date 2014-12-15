/**
 * Created by Arkadiusz on 2014-12-12.
 */
import Graph._
import Music._
object Main {
  def main (args: Array[String]) {

    var ar1 = new Artist("Cher")
    var gr = new Graph(ar1)
    gr.getNode("Cher")
  }
}
