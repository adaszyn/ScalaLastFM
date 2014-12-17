package Graph

import Music.Artist
import exceptions._

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
    var vert: Vertex = null
    if(!isVertexPresent(name)) throw new VertexNotFoundException("W grafie nie ma wierzcholka o nazwie: "+name)
    for (v<-Vertices) {
      if (v.getID() == name) vert = v
    }
    vert
  }
  def extend(v:Vertex, number: Int) ={
    var amount: Int = 0
    var counter: Int = 0
    val sim = v.getSimilars()
    while(amount < number && counter < sim.length) {
      if (!isVertexPresent(sim(counter))) {
        val vert = new Artist(sim(counter))
        Vertices += vert
        Edges+= new Edge(v, vert )
        amount+=1
      }
      counter+=1
    }
    if(amount!=number) throw new NotEnoughSimilarsException("Nie mozna dodac az tylu podobnych")
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
