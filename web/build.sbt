import CommonSettings._

lazy val web = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(settings)
  .settings(
    name := "blog-aggregator-web",
    version := "0.1.0"
  )
  .settings(
    libraryDependencies ++= Seq(
      guice, jdbc,
      ehcache, ws
    )
  )