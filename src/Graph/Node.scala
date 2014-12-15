package Graph

/**
 * Created by wojciech on 14.12.14.
 */
import scala.collection.mutable.ArrayBuffer
trait Node {
  def getNeighbours(): ArrayBuffer[Node]
  def getWeight(): Int
  def connect(node : Node): Edge
  def getID():String
}
