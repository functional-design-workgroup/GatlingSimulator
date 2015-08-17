package org.awesome.gatling.openrtb

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SimpleSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8080")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Version").during(60.seconds)(
    exec(http("version").get("/version"))
  )

  setUp(scn.inject(atOnceUsers(10)).protocols(httpConf))
}
