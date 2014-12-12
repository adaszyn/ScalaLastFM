/**
 * Created by Arkadiusz on 2014-12-12.
 */
import Graph._
import Music._
object Main {
  def main (args: Array[String]) {
    var ar1 = new Artist("artist1")
    var ar2 = new Artist("artist2")
    var ver1 = new Vertex(ar1)
    var ver2 = new Vertex(ar2)
    var ed1 = new Edge(ver1, ver2)
  }
}
