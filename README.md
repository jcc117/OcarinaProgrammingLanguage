# Ocarina - A General Purpose Programming Language

# What is Ocarina?
Ocarina is a programming language heavily influenced by Python, Java, C#, and Ruby. It includes single class inheritance and the ability to create nested
inner classes. It is an interpretted language that runs on a Java based interpretter (which means we can use the JVM for portability!). The design of
this language is meant to be simple in order to give first time language learners an easier time learning over something as wordy as Java.

All integers of any size and floats can be referenced by the same keyword. The interpretter shall handle any size of integer or float that is thrown at
it. It also incluces a built in hashmap variable type due to the commonality of use of the data structure. 

This language is also unique in that it takes into account some programming aspects for software development. This language shall eventually include built in
mocks and stubs in order to more easily facilitate program testing enviroments so third party libraries do not have to be developed.
Ocarina also has a built-in debugger within its interpretter.

Ocarina is compiled with a JFlex lexer and JavaCUP parser. Source code is compiled to an intermediate representation that is then run on the Ocarina 
interpretter in a similar way to Java class files and the JVM.

For examples, please navigate to the 'examples' folder.

Note: It appears that I haven't been keeping up with this project. Commits have been sparse lately. That is not the case. I've been doing research into other languages to 
gather ideas. Now is the time to make design changes before I move further with developing a symbol table. I wrote the code for the file catalog before this since it 
doesn't really depend on the grammar itself.

# What are the goals of Ocarina?
1. A well-rounded, general-purpose programming language
2. English readable and very easy to understand
3. Easy to learn for experienced and non-experienced programmers alike
4. Portable
5. Provide some necessary built-in tools for modern software engineering practices

# How do I compile an Ocarina file?
With the following command:

*ocarinac filename.ocar*

This shall produce a file called filename.rina, which runs on the Ocarina interpretter.

# How do I run an Ocarina file?
With the following command:
*ocarina filename.rina*

# How do I install Ocarina?
To be determined.

# Features for Ocarina
	*Built-in Debugger within the Interpreter*
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
	Syntactical rule development(what's considered an error other than grammar violations)
	Planning of the Ocarina Standard Library
	Planning of Symbol Table Builder

# Recently Accomplished
	Added static variables, functions, and classes
	Development of file catalog and searcher to compile imported files with a variable degree of parallelism
	Improved the way functions are called to be a bit more conventional
	Added foreach loops
	Cleaned up operator precedence
	Compiler Architecture Design
	Initial Design of Symbols for Symbol Table
	Better handling of types for symbol table
	Initial implementation of inner scopes within a method

# Items Under Consideration For Later Release
	*repl mode*
	*casting*
	*generics*
	*unicode strings*
	*lambda functions*