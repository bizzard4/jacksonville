package com.biz4company.jacksonville.util.metrics

import com.twitter.finagle.stats.{DefaultStatsReceiver, StatsReceiver}

object Metrics {
  val baseMetrics: StatsReceiver = DefaultStatsReceiver.get
  final lazy val serverMetrics: StatsReceiver = baseMetrics.scope("srv", "jacksonville")
}
