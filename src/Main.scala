/**
 * Created by Arkadiusz on 2014-12-12.
 */
import Graph._
import Music._
object Main {
  def main (args: Array[String]) {
    //var ar1 = new Artist("artist1")
    var ar2 = new Artist("Scorpions")
    //ar2.getInfo()
    for(artist<-ar2.getSimilars()){
      artist.getInfo()
    }


  }
}
