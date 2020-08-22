name := "jacksonville"

version := "0.1"

scalaVersion := "2.12.12"

libraryDependencies ++= Seq(
  "com.github.finagle" %% "finch-core" % "0.31.0",
  "com.github.finagle" %% "finch-circe" % "0.31.0",
  "io.circe" %% "circe-generic" % "0.9.0",
  "com.twitter" %% "twitter-server" % "1.30.0",
)