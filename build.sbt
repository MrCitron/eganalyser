import Dependencies._

lazy val eganalyser = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.metinosman",
      scalaVersion := "2.11.11",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "eganalyser",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      mongoSpark
    ) ++ spark
  )
