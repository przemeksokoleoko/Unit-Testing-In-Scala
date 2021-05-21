name := "Unit Testing in Scala"

version := "0.1"

scalaVersion := "2.13.1"

// libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test
// libraryDependencies += "org.scalamock" %% "scalamock" % "5.1.0" % Test

// for versions 4.0+ use this dependency:
libraryDependencies += "org.scalamock" %% "scalamock" % "5.1.0" % Test
// as ScalaTest is now an "optional" dependency, you should include that yourself:
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % Test

