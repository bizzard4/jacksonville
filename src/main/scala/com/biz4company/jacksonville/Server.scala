package com.biz4company.jacksonville

import com.biz4company.jacksonville.api.v1.EnvApi.EnvApi
import com.twitter.app.{App => TwitterApp}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Http, ListeningServer, Service}
import com.twitter.util.Await
import io.circe.generic.auto._
import io.finch._
import io.finch.circe._

private[jacksonville] trait ServiceFeature extends TwitterApp

trait BootableService { self: TwitterApp =>
  private val server = Http.server

  val api = "api" :: "v1" :: EnvApi.api

  def apiService: Service[Request, Response] = api.toServiceAs[Application.Json]
  def boot(): ListeningServer = {
    val booted = server.serve("0.0.0.0:8081", apiService)
    onExit {
      booted.close()
      ()
    }
    booted
  }
}

object Server extends BootableService with ServiceFeature {
  def main(): Unit = {
    val server = boot()
    Await.ready(server)
  }
}
