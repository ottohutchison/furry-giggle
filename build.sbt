import org.scalajs.sbtplugin.ScalaJSPlugin

name := "furry-giggle"

organization := "com.github.ottohutchison"

version := "0.1"

scalaVersion := "2.11.7"

enablePlugins(ScalaJSPlugin)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.0"
)
