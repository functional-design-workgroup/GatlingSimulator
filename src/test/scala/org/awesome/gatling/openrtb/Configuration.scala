package org.awesome.gatling.openrtb

import java.util.concurrent.TimeUnit

import com.typesafe.config.ConfigFactory

import scala.concurrent.duration._

case class Configuration(configurationPrefix: String) {

  val config = ConfigFactory.load.getConfig(configurationPrefix)

  val baseUrl = config.getString(Keys.baseUrl)
  val atOnceUsers = config.getInt(Keys.atOnceUsers)
  val duration = config.getDuration(Keys.duration, TimeUnit.SECONDS).seconds
  val sample = config.getString(Keys.sample)

  object Keys {
    val baseUrl = "baseUrl"
    val atOnceUsers = "atOnceUsers"
    val duration = "duration"
    val sample = "sample"
  }
}

