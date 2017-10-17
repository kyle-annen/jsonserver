#!/bin/bash
sbt makePom
cp target/json*.pom pom.xml
mvn deploy
sbt assembly deployHeroku