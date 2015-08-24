package org.awesome.gatling.openrtb

import io.gatling.core.feeder.FeederSupport
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class OpenRtbSimulation extends Simulation with FeederSupport {

  val config = Configuration("simpleSimulation")

  val httpConf = http
    .baseURL(config.baseUrl)
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val feeder = separatedValues(config.sample, '|').circular.random

  val scn = scenario("openrtb")
    .during(config.duration)(
      feed(feeder)
      .exec(http("openrtb").post("${url}").body(StringBody("${body}")))
    )

  setUp(scn.inject(atOnceUsers(config.atOnceUsers)).protocols(httpConf))
}
