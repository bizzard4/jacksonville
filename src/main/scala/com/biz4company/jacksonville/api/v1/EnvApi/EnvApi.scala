package com.biz4company.jacksonville.api.v1.EnvApi

import com.biz4company.jacksonville.model.EnvEntry
import com.biz4company.jacksonville.util.metrics.ResponseOps
import com.twitter.finagle.http.{Response, Status}
import com.twitter.io.Buf
import io.finch.{Endpoint, _}
import io.finch.syntax._

object EnvApi {
  val api = "env" :: (ePing :+: eAdd)

  def eAdd: Endpoint[EnvEntry] =
    put("add") {
      val response = EnvEntry("date", 35.5, 34.6, 1000)
      // Send to storage
      Ok(response)
    }

  def ePing: Endpoint[String] =
    get("ping") {
      Ok("pong")
    }

}
