package com.biz4company.jacksonville.util.metrics

import java.nio.ByteBuffer

import com.twitter.finagle.http.Version.Http11
import com.twitter.finagle.http.{Fields, Response, Status, Version}
import com.twitter.io.Buf
import io.circe.{Encoder, Json, Printer}
import io.finch.Encode

object ResponseOps {
  private val DefaultHttpVersion = Http11

  private def newResponse(status: Status, version: Version) = {
    val response = Response()
    response.status = status
    response.version = version
    response
  }

  /** Build a basic text response.
   *
   * @param status
   * @param content
   * @param version
   * @return
   */
  final def textResponse(status: Status, content: Buf, version: Version = DefaultHttpVersion): Response = {
    val response = newResponse(status, version)
    response.headerMap.add(Fields.ContentLength, content.length.toString)
    response.headerMap.add(Fields.ContentLanguage, "en")
    response.headerMap.add(Fields.ContentType, "text/plain")
    response.content = content
    response
  }

  private val printer = Printer.noSpaces.copy(dropNullValues = true)
  final def jsonToByteBuffer(json: Json): ByteBuffer = printer.prettyByteBuffer(json)
  final def byteBufferToBuf(bytes: ByteBuffer): Buf = Buf.ByteBuffer.Owned(bytes)
  final def dataJsonEncode[A](implicit encoder: Encoder[A]): Encode.Json[A] =
    Encode.json { (a, _) =>
      byteBufferToBuf(jsonToByteBuffer(Json.obj("data" -> encoder.apply(a))))
    }
}
