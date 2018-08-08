#!/bin/sh
#Build the interpreter

jflex OcarinaLexer.flex
java -jar java-cup-11a.jar OcarinaParser.cup
javac ast/*.java
javac symboltable/*.java
javac -cp ".;java-cup-11a.jar" Ocarinac.java
$SHELL