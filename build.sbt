organization := "com.rayrobdod"

scalaVersion := "2.10.5"

crossScalaVersions := Seq("2.10.5", "2.11.7")

scalacOptions := Seq("-deprecation", "-language:_")

description := "anti-xml"

name := "anti-xml"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.3" % "test",
  "org.specs2" %% "specs2" % "2.3.13" % "test"
)

libraryDependencies <++= (scalaBinaryVersion) { (sv) => sv match {
    case "2.11" => Seq("org.scala-lang.modules" %% "scala-xml" % "1.0.2" % "provided")
    case _ => Nil
  }
}
      
initialCommands in console := """import com.codecommit.antixml._"""

scalacOptions in Compile in doc <++= (unmanagedSourceDirectories in Compile) map {
  (usd) =>
    val scalaSrc: File = (usd filter {
      _.toString endsWith "scala"
    }).head
    Seq(
      "-sourcepath", scalaSrc.toString,
      "-doc-source-url", "https://github.com/arktekk/anti-xml/tree/master/src/main/scala€{FILE_PATH}.scala"
    )
}
