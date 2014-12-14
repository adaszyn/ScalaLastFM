package Music

/**
 * Created by wojciech on 12.12.14.
 */

import scala.collection.mutable.ArrayBuffer

class Artist (val name: String, val mbid: String, val url: String, val tags: ArrayBuffer[String]) {

  def this(name: String)={
    this(name, InfoGetter.getMBID(name), InfoGetter.getURL(name), InfoGetter.getTags(name))
  }
 def getInfo(): Unit ={
    println(name)
    println(mbid)
    println(url)
    println(tags)
  }
}