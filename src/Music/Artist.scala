package Music

/**
 * Created by wojciech on 12.12.14.
 */

import scala.collection.mutable.ArrayBuffer
import scala.io.{Codec, Source}
import scala.xml.XML

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
  def getSimilars(): ArrayBuffer[Artist] = {
    val html = Source.fromURL("http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=" + name.replaceAll(" ", "%20") + "&api_key=3723f4ce9e123e46cff24251666d761a")(Codec.ISO8859)
    val s = html.mkString
    val obj = XML.loadString(s)
    var similar = ArrayBuffer[Artist]()
    for (art <- obj \\ "similar" \\ "artist") {
      var tmp = (art \ "name").toString
      tmp = tmp.slice(6, tmp.length - 7)
      similar += new Artist(tmp)
    }
    similar
  }
}