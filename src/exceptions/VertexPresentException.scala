package exceptions

/**
 * Created by Arkadiusz on 2014-12-17.
 */
class VertexPresentException (messege: String = null, cause: Throwable = null) extends RuntimeException(messege, cause) {
  override def getMessage = messege
}
