package Music

/**
 * Created by wojciech on 12.12.14.
 */

import scala.collection.mutable.ArrayBuffer
import scala.io.{Codec, Source}
import scala.xml.XML
import Graph.{Edge, Node}

class Artist (val name: String, val mbid: String, val url: String, val tags: ArrayBuffer[String]) extends Node{


  def this(name: String)={
    this(name, InfoGetter.getMBID(name), InfoGetter.getURL(name), InfoGetter.getTags(name))
  }
  override def toString()={
    name
  }
 def getInfo(): Unit ={
    println(name)
    println(mbid)
    println(url)
    println(tags)
  }
  def getSimilars(n: Int): ArrayBuffer[Node] = {
    val s = Source.fromURL("http://ws.audioscrobbler.com/2.0/?method=artist.getsimilar&artist="+name.replaceAll(" ", "%20")+"&api_key=3723f4ce9e123e46cff24251666d761a&limit="+n)(Codec.ISO8859).mkString
    val obj = XML.loadString(s)
    var similar = ArrayBuffer[Node]()
    for (art <- obj \\ "artist" ) {
      var tmp = (art \ "name").toString
      tmp = tmp.slice(6, tmp.length - 7)
      similar += new Artist(tmp)
    }
    similar
  }

  override def getNeighbours(): ArrayBuffer[Node] = null

  override def connect(node: Node): Edge = {
    Edge(this, node)
  }

  override def getWeight(): Int = 0

  override def getID(): String = name.replaceAll(" ", "%20").toLowerCase

  override def ==(that: Node): Boolean = {
     (getID()==that.getID())
  }
}