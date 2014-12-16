package Graph

import scala.collection.mutable.ArrayBuffer

/**
 * Created by wojciech on 12.12.14.
 */
class Graph(seed: Vertex) {
  var Edges = ArrayBuffer[Edge]()
  var Vertices = ArrayBuffer[Vertex]()

  Vertices+=seed

  def isEdgePresent(e: Edge): Boolean={
    Edges.contains(e)
  }
  def isNodePresent(v: Vertex): Boolean= {
    Vertices.contains(v)
  }
  def isNodePresent(name: String)={
    var x = (Vertices.map((n:Vertex)=>(n.getID() == name))).reduce((v1, v2)=>v1||v2)
    print(x)
  }

  def getNode(name: String)={
    for (v<-Vertices if v.getID() == name) v
  }
  def extend(weight: Int) ={
  null
  }
//  def getCenter(
}
