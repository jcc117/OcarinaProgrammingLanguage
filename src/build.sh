#!/bin/sh
#Build the interpreter

cd lexer_parser
jflex OcarinaLexer.flex
java -jar ../java-cup-11a.jar OcarinaParser.cup
javac -cp ".;java-cup-11.jar" *.java
cd ..
javac ast/*.java
javac symboltable/*.java
javac filecatalog/*.java
javac -cp ".;java-cup-11a.jar" Ocarinac.java
$SHELL