name := "jacksonville"

lazy val baseSettings = Seq(
  version := "0.1",
  scalaVersion := "2.12.12",
  crossPaths := false,
  exportJars := true,
  publishArtifact in (Compile, packageBin) := false,
  publishArtifact in (Compile, packageDoc) := false,
  publishArtifact in (Compile, packageSrc) := false,
  libraryDependencies ++= Seq(
    "com.github.finagle" %% "finch-core" % "0.31.0",
    "com.github.finagle" %% "finch-circe" % "0.31.0",
    "io.circe" %% "circe-generic" % "0.9.0",
    "com.twitter" %% "twitter-server" % "1.30.0",
  ),
)

lazy val appJacksonville = project.in( file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(baseSettings)
  .settings(
    name := "jacksonville",
    dockerRepository := "",
    mainClass in (Compile, run) := Some("com.biz4company.jacksonville.Server"),
  )