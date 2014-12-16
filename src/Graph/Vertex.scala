package Graph

/**
 * Created by wojciech on 14.12.14.
 */
import scala.collection.mutable.ArrayBuffer
trait Vertex {
  def getNeighbours(): ArrayBuffer[Vertex]

  def getWeight(): Int

  def connect(node: Vertex): Edge

  def getID(): String

  def ==(obj: Vertex): Boolean

}