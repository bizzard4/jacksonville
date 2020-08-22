package com.biz4company.jacksonville.model

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._
import io.circe.generic.auto._

/** Model representing entry in prometheus
 *
 * @param dateTime      Date when the data was received by the service.
 * @param temperature   Temperature in C
 * @param humidity      Humidity in % (0-100)
 * @param atmosphericPressure Pressure in hPa (260 - 1260)
 */
case class EnvEntry(dateTime: String /* TODO find good datetime */ , temperature: Double, humidity: Double, atmosphericPressure: Double)
//object EnvEntry {
//  implicit val encoder: Encoder[EnvEntry] = deriveEncoder[EnvEntry]
//  implicit val decoder: Decoder[EnvEntry] = deriveDecoder[EnvEntry]
//}
