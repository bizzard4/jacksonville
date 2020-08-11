import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response, Status}
import com.twitter.util.{Await, Future}

object Server extends App {
  val service = new Service[Request, Response] {
    override def apply(req: Request): Future[Response] = Future.value(Response(req.version, Status.Ok))
  }
  val server = Http.serve("0.0.0.0:8080", service)
  Await.ready(server)
}