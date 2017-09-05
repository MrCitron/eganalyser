import sbt._

object Dependencies {
  lazy val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % "3.0.3"
  lazy val spark: Seq[ModuleID] = Seq(
  "org.apache.spark" %% "spark-core" % "2.2.0",
  "org.apache.spark" %% "spark-sql" % "2.2.0")
  lazy val mongoSpark: ModuleID = "org.mongodb.spark" %% "mongo-spark-connector" % "2.2.0"
}
