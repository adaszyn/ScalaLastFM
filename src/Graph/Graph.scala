package Graph

import exceptions.VertexPresentException

import scala.collection.mutable.ArrayBuffer

/**
 * Created by wojciech on 12.12.14.
 */
class Graph(seed: Vertex) {
  var Edges = ArrayBuffer[Edge]()
  var Vertices = ArrayBuffer[Vertex]()

  Vertices+=seed

  def isEdgePresent(e: Edge): Boolean=(Edges.map((ed:Edge)=>(e==ed))).fold(false)((e1, e2) => e1 || e2)
  def isVertexPresent(v: Vertex): Boolean= {
    Vertices.contains(v)
  }
  def isVertexPresent(name: String)= (Vertices.map((n:Vertex)=>(n.getID() == name))).reduce((v1, v2)=>v1||v2)

  def getVertex(name: String)={
    for (v<-Vertices if v.getID() == name) v
  }
  def extend(number: Int) ={
  null
  }
  def getSimilarsInGraph(v: Vertex): ArrayBuffer[Vertex]={
    var res = ArrayBuffer[Vertex]()
    for(vert <- Vertices)
      if(v.getSimilars().contains(vert.getID())) res+=vert
    res
  }

  def addVertex(v: Vertex): Unit ={
    if(isVertexPresent(v.getID())) throw new VertexPresentException("W grafie jest juz taki wierzcholek!")
    val Similar = getSimilarsInGraph(v)
    Vertices+=v
    for(v2 <-Similar){
      if(!isEdgePresent(new Edge(v,v2))) Edges+=new Edge(v,v2)
    }
  }
//  def getCenter(
}
