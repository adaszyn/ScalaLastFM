package Music

/**
 * Created by wojciech on 12.12.14.
 */

import scala.collection.mutable.ArrayBuffer
import scala.io.{Codec, Source}
import scala.xml.XML
import Graph.{Edge, Node}

class Artist (val name: String, val mbid: String, val url: String, val tags: ArrayBuffer[String], val Similars: ArrayBuffer[String]) extends Node{


  def this(name: String)={
    this(name, InfoGetter.getMBID(name), InfoGetter.getURL(name), InfoGetter.getTags(name), InfoGetter.getSimilars(name))
  }
  override def toString()={
    name
  }
 def getInfo(): Unit ={
    println(name)
    println(mbid)
    println(url)
    println(tags)
    println(Similars)
  }

  override def getNeighbours(): ArrayBuffer[Node] = null

  override def connect(node: Node): Edge = {
    Edge(this, node)
  }

  override def getWeight(): Int = 0

  override def getID(): String = name

  override def ==(that: Node): Boolean = {
     (getID()==that.getID())
  }

}