package Test

/**
 * Created by wojciech on 15.12.14.
 */
import org.scalatest._
import org.mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatest.mock.EasyMockSugar._
import Graph.{Edge,Node}
class EdgeTest extends FlatSpec{
  "An Edge" should "compare itself with another edge" in{
    val node1 = mock[Node]("band1")
    val node2 = mock[Node]("band2")
//    val node3 = mock[Node]
//    val node4 = mock[Node]
    val edge1 = mock[Edge](node1, node2)
    val edge2 = mock[Edge](node2, node1)
    assert(edge1 == edge2)
  }
}
