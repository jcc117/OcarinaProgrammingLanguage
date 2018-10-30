@echo off

REM Please adjust OCARINA_HOME to suit your needs
REM do not add a trailing backslash

set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_79
set OCARINA_HOME=C:\Users\Jordan\Ocarina

java -cp "%OCARINA_HOME%\src;%OCARINA_HOME%\src\java-cup-11a.jar" "Ocarinac" %1 %2 %3 %4 %5 %6 %7 %8 %9