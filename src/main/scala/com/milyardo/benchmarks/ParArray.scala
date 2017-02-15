package com.milyardo.benchmarks

import org.openjdk.jmh.annotations.Benchmark
import scala.util.Random

class ParArray {
  import ParArray._

  @Benchmark
  def mapData = data.par.map(sin)

  @Benchmark
  def mapParData = parData.map(sin)
}

object ParArray {
  val data = Array.fill(10000000)(Random.nextDouble)
  val parData = data.par
  val sin = (x: Double) => Math.sin(x)
}
