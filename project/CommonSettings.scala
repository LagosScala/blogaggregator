import sbt._
import Keys._

object CommonSettings {
  lazy val settings = Seq(
    organization := "org.lagoscala.blogaggregator",
    resolvers    ++= Seq(
      Resolver.sonatypeRepo("snapshots"),
      "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/"
    )
  )

  lazy val akkaDependency = "com.typesafe.akka" %% "akka-actor" % "2.5.9"
}