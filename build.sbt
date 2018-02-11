import CommonSettings._

lazy val blogaggregator = (project in file("."))
  .aggregate(web, core, repository, slackbot)


lazy val repository = (project in file("repository"))
  .settings(
    name := "blog-aggregator-repository",
    version := "0.1.0"
  )
  .settings(CommonSettings.settings)

lazy val core = (project in file("core"))
  .settings(settings)
  .settings(
    libraryDependencies ++= Seq(
      akkaDependency,
      "org.reactivemongo" %% "reactivemongo"       % "0.12.7",
      "org.mongodb.scala" %% "mongo-scala-driver"  % "2.1.0"
    )
  )
  .dependsOn(repository)

lazy val slackbot = (project in file("slackbot"))
  .settings(
    name := "blog-aggregator-slackbot",
    version := "0.1.0"
  )
  .settings(settings)

lazy val web = (project in file("web"))
  .enablePlugins(PlayScala)
  .settings(settings)
  .settings(
    name := "blog-aggregator-web",
    version := "0.1.0"
  )
  .settings(
    libraryDependencies ++= Seq(
      guice, jdbc,
      ehcache, ws,
      "org.scalatestplus.play" %% "scalatestplus-play"   % "3.1.2" % Test,
      "com.typesafe.akka"      %% "akka-testkit"         % "2.5.9" % Test
    )
  )

//lazy val testsuite = (project in file("testsuite"))
//  .settings(
//    name := "blog-aggregator-testsuite",
//    version := "0.1.0"
//  )
//  .settings(settings)
//  .settings(
//    libraryDependencies ++= Seq(
//      "org.scalatestplus.play" %% "scalatestplus-play"   % "3.1.2" % Test,
//      "com.typesafe.akka"      %% "akka-testkit"         % "2.5.9" % Test
//    )
//  )
//  .dependsOn(web, core, repository, slackbot)
