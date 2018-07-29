// this file exists only so I can have quick access to a REPL
// with the correct dependencies.

scalaVersion in ThisBuild := "2.12.6"
scalacOptions in ThisBuild ++= Seq(
  "-language:_",
  //"-Xsource:2.13",
  "-Ypartial-unification",
  "-deprecation"
)

val derivingVersion = "1.0.0-RC5"

libraryDependencies ++= Seq(
  "com.github.mpilquist" %% "simulacrum"            % "0.12.0",
  "com.chuusai"          %% "shapeless"             % "2.3.3",
  "com.fommil"           %% "deriving-macro"        % derivingVersion % "provided",
  "com.fommil"           %% "scalaz-deriving"       % derivingVersion,
  "org.scalaz"           %% "scalaz-effect"         % "7.2.25",
  "org.scalaz"           %% "scalaz-ioeffect"       % "2.8.0",
  "eu.timepit"           %% "refined-scalaz"        % "0.9.0",
  "com.lihaoyi"          %% "sourcecode"            % "0.1.4",
  "io.estatico"          %% "newtype"               % "0.4.2"
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.7")
addCompilerPlugin(
  "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full
)

addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.2.4")
addCompilerPlugin("com.fommil" %% "deriving-plugin"    % derivingVersion)

scalacOptions in (Compile, console) -= "-Xfatal-warnings"
initialCommands in (Compile, console) := Seq(
  "scalaz._, Scalaz._"
).mkString("import ", ",", "")

//scalafmtOnCompile in ThisBuild := true
scalafmtConfig in ThisBuild := Some(file("project/scalafmt.conf"))
scalafmtOnCompile in ThisBuild := true
