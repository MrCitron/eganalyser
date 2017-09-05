package com.metinosman.eganalyser

import com.mongodb.spark.MongoSpark
import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]) {
    val spark = SparkSession.builder()
      .master("local")
      .appName("MongoSparkConnectorIntro")
      .config("spark.mongodb.input.collection", "game")
      .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/egdb")
      .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/egdb")
      .getOrCreate()

    val sc = spark.sparkContext

    val logData = MongoSpark.load(sc).keyBy(d => d.getString("name") + d.getString("city")).distinct().values
    val numAs = logData.filter(line => line.getString("name").contains("a")).count()
    val numBs = logData.filter(line => line.getString("name").contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}
