//scalaVersion := "2.13.8"
scalacOptions += "-language:higherKinds"
addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.13.2" cross CrossVersion.full)

scalacOptions += "-Ydelambdafy:inline"
scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked"
)
val Http4sVersion = "1.0.0-M21"
val CirceVersion = "0.14.0-M5"
libraryDependencies ++=  Seq(
  "org.scalaj" %% "scalaj-http" % "2.4.2",
  "com.lihaoyi" %% "ujson" % "0.9.5",
   "org.http4s"      %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"      %% "http4s-circe"        % Http4sVersion,
  "org.http4s"      %% "http4s-dsl"          % Http4sVersion,
  "io.circe"        %% "circe-generic"       % CirceVersion,
)