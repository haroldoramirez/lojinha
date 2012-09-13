import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName         = "lojinha"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "com.amazonaws" % "aws-java-sdk" % "1.3.14",
    "se.radley" %% "play-plugins-salat" % "1.0.9",
    "org.mockito" % "mockito-core" % "1.9.0" % "test"
  ) map (_.withSources)

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    routesImport += "se.radley.plugin.salat.Binders._",
    templatesImport ++= Seq(
      "org.bson.types.ObjectId",
      "models.dao._"
    )
  )
}
