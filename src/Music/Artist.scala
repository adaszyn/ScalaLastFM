package Music

/**
 * Created by wojciech on 12.12.14.
 */
import scala.io.{Codec, Source}
import scala.xml.XML
class Artist(val name: String) {
  def getInfo() = {
    val html = Source.fromURL("http://ws.audioscrobbler.com/2.0/?method=artist.getsimilar&artist="+name+"&api_key=3723f4ce9e123e46cff24251666d761a")(Codec.ISO8859)
    val s = html.mkString
    val obj = XML.loadString(s)
    println(obj \ "artist")
    /*for (art <- (obj \\ "artist")){
      println(art \ "name")
    }*/
  }

}
