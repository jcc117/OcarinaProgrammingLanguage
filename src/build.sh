#!/bin/sh
#Build the interpreter

cd lexer_parser
jflex OcarinaLexer.flex
java -jar ../java-cup-11a.jar OcarinaParser.cup
cd ..
javac -cp ".;java-cup-11a.jar" Ocarinac.java
$SHELL