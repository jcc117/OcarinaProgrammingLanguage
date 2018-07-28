# Ocarina - An Esoteric Programming Language

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

# Can I compile multiple files at once?
In later versions yes. For the initial release, no.

# How do I run an Ocarina file?
With the following command:

	*ocarina filename.rina*

# How do I install Ocarina?
To be determined.

# Features for Ocarina
	*Built-in Debugger within the Interpreter*
	*Handling of Integers and Floats of Any Size*
	*Heavy use of keywords to promote readability*
	*Strictly Typed, but also supports var types (similar to C#)*
	*Public and Private Classes and Subroutines*
	*Variable Names, Class Names, and Subroutine Names which can include "?"*
	*Function-Type variables*
	*Functions not strictly tied to classes*
	*Nested inner classes to any level desired*
	*Packages (called Sages in this language)*
	*Exception handling*

# Progress report
	Parser and Lexer Development
	Finalization of Grammar
	Development of pretty printer for parser testing

# Items Under Consideration For Later Release
	*operator overloading*
	*repl mode*
	*casting*
	*generics*
	*unicode strings*
	*lambda functions*