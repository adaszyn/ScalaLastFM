package Graph

/**
 * Created by wojciech on 12.12.14.
 */
class Edge(val v1: Vertex, val v2: Vertex) {
override def toString()={
  v1.toString +"--" + v2.toString
}
def == (e: Edge)={
  (v1==e.v1 && v2 == e.v2) || (v1 == e.v2 && v2==e.v1)
}

}
object Edge{
  def apply(v1: Vertex, v2: Vertex)={
  new Edge(v1, v2)
}
}