package Music

/**
 * Created by wojciech on 12.12.14.
 */

import scala.collection.mutable.ArrayBuffer
import scala.io.{Codec, Source}
import scala.xml.XML
import Graph.{Vertex, Edge}

class Artist (val name: String, val mbid: String, val url: String, val tags: ArrayBuffer[String], val Similars: ArrayBuffer[String]) extends Vertex{


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

  override def getNeighbours(): ArrayBuffer[Vertex] = null

  override def connect(v: Vertex): Edge = {
    Edge(this, v)
  }

  override def getWeight(): Int = 0

  override def getID(): String = name

  override def ==(that: Vertex): Boolean = {
     (getID()==that.getID())
  }

}