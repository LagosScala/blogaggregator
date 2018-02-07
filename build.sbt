lazy val commonSettings = Seq(
  name         := "blogaggregator",
  organization := "org.lagoscala.blogaggregator",
  version      := "0.1.0",
  resolvers += Resolver.sonatypeRepo("snapshots")
)

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .settings(
    libraryDependencies ++= Seq(
      guice, jdbc,
      ehcache, ws,
      "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
      "org.reactivemongo" % "play2-reactivemongo_2.12" % "0.12.7-play26",
      "com.h2database" % "h2" % "1.4.196"
    )
  )


