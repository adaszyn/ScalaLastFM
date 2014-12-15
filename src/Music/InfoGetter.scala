package Music

import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer
import scala.io.{Codec, Source}
import scala.xml.XML

/**
 * Created by Arkadiusz on 2014-12-14.
 */

object InfoGetter {
  def getMBID(name: String): String = {
    val obj = InfoGetter.createSource(name)
    val art = obj \ "artist"
    var mbid = ((art \ "mbid").toString)
    mbid = mbid.slice(6, mbid.length - 7)
    mbid
  }

  def getURL(name: String): String = {
    val obj = InfoGetter.createSource(name)
    val art = obj \ "artist"
    var url = (art \ "url").toString
    url = url.slice(5, url.length - 6)
    url
  }
  def createSource(name: String)={
    val s = Source.fromURL("http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=" + name.replaceAll(" ", "%20") + "&api_key=3723f4ce9e123e46cff24251666d761a")(Codec.ISO8859).mkString
    val obj = XML.loadString(s)
    obj
  }

  def getTags(name: String): ArrayBuffer[String] = {
    val obj = InfoGetter.createSource(name)
    var tags = ArrayBuffer[String]()
    for (art <- obj \\ "tag") {
      var tmp = (art \ "name").toString
      tmp = tmp.slice(6, tmp.length - 7)
      tags += tmp
    }
    tags
  }
  def getSimilars(name: String): ArrayBuffer[String] = {
    val s = Source.fromURL("http://ws.audioscrobbler.com/2.0/?method=artist.getsimilar&artist="+name.replaceAll(" ", "%20")+"&api_key=3723f4ce9e123e46cff24251666d761a")(Codec.ISO8859).mkString
    val obj = XML.loadString(s)
    var similar = ArrayBuffer[String]()
    for (art <- obj \\ "artist" ) {
      var tmp = (art \ "name").toString
      tmp = tmp.slice(6, tmp.length - 7)
      similar += tmp
    }
    similar
  }
}
