package exceptions

/**
 * Created by Arkadiusz on 2014-12-17.
 */
class VertexNotFoundException (message: String = null, cause: Throwable = null) extends RuntimeException(message, cause) {
  override def getMessage = message
}
