package Boot

/**
 * Created by nikolatonkev on 2015-08-04.
 */

import Web.{RoutingActor}
import akka.pattern.ask
import akka.actor._
import akka.io.IO
import akka.util.Timeout
import scala.concurrent.duration._
import spray.can.Http

object BootLoader  extends App {
  implicit val system = ActorSystem() //"nous-dynamics-data-composer-system"

  val service = system.actorOf(Props[RoutingActor]) //"nous-dynamics-data-composer-service"

  implicit val timeout = Timeout(15.seconds)
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
}
