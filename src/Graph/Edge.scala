package Graph

/**
 * Created by wojciech on 12.12.14.
 */
class Edge(val n1: Node, val n2: Node) {
override def toString()={
  n1.toString +"--" + n2.toString
}
def == (e: Edge)={
  (n1==e.n1 && n2 == e.n2) || (n1 == e.n2 && n2==e.n1)
}

}
object Edge{
    def apply(node1: Node, node2: Node)={
      new Edge(node1, node2)
  }
}