package Graph

import scala.collection.mutable.ArrayBuffer

/**
 * Created by wojciech on 12.12.14.
 */
class Graph {
var Vertices = ArrayBuffer[Node]();
  def addVertex(vertex: Node): Unit ={
    Vertices += vertex;
}
//  def getCenter(
}
