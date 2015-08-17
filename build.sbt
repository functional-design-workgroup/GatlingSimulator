enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    name := "GatlingSimulator",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.4"
  )

libraryDependencies ++= {
  val gatlingV = "2.1.7"
  Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingV % "test",
    "io.gatling"            % "gatling-test-framework"    % gatlingV % "test"
  )
}
