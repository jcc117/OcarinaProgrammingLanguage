# Ocarina - A General Purpose Programming Language
![Logo](https://github.com/jcc117/Ocarina/blob/master/Logo.png)

# What is Ocarina?
Ocarina is a strongly typed, general purpose programming language heavily influenced by Python, Java, JavaScript, C#, C, and Ruby.
It is compiled to byte-code and run via an interpreter. It is designed to give the programmer the basic functionality of most programming languages but 
without the restrictions that many of them enforce. It is much more free flowing than languages like Java and C++, but allows for some type control that 
languages like Ruby, Python, and JavaScript don't provide. It is meant to be loose, yet elegant, compact, yet precise. Ocarina aims to take the best that 
all other programming languages provide and combine them into an effective programming language.

# What are the goals of Ocarina?
1. A well-rounded, general-purpose programming language
2. English readable and very easy to understand
3. Easy to learn for experienced and non-experienced programmers alike
4. Portable
5. Provide some necessary built-in tools for modern software engineering practices

# Where do I learn how to program in Ocarina?
See ProgrammersGuide.md for a quick introduction on the basics of Ocarina. It is a very quick explination on the syntax of Ocarina. *It is not a guide 
suited for those who have no programming experience.* 

# How do I compile an Ocarina file?
Navigate to the source folder and run the following command:

*java -cp ".;java-cup-11a.jar" Ocarinac [path to file to be compiled]*

This is temporary while the project is still being built.

Ocarina files use the .ocar extension.

# How do I run an Ocarina file?
With the following command:

	ocarina filename.ocar

where filename.ocar is the file which you would like to run.

# How do I install Ocarina?
First, navigate to the bin folder and open ocarina.bat. Change JAVA_HOME to the directory where Java is set up on your machine and change OCARINA_HOME 
to the location of the Ocarina folder. Then add the bin folder to your path.

# Features for Ocarina
	*Handling of Integers and Floats of Any Size*
	*Heavy use of keywords to promote readability with the option to use traditional operators*
	*Strictly Typed, but also supports var types (similar to C#)*
	*Public, Private, and Static Classes and Functions*
	*Variable Names, Class Names, and Functions Names which can include "?"*
	*Function-Type variables*
	*Functions not strictly tied to classes*
	*Nested inner classes to any level desired*
	*Exception handling*
	*"Double quoted strings" and 'Single quoted strings', similar to JavaScript*

# In Planning
	Symbol Table Unit Tests
	Symbol Table Pass 1 Unit Tests
	Syntactical rule development(what's considered an error other than grammar violations)
	Planning of the Ocarina Standard Library
	Symbol Table Builder Phase 2
	Var-Type Resolver
	Documentation/Comments

# Recently Accomplished
	Mock Symbol Table

# Under Consideration
	Import specification files as an option to manage file imports
	Enums


# Items Under Consideration For Later Release
The only reason many of these are not included in this version is so I can keep moving foward with what I have.
* Repl mode
* Casting
* Generics
* Unicode strings
* Strict mode - enforcing Java-like object oriented programming practices when compiling
* Multi-threading
* Interfaces
