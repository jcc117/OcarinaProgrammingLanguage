# Ocarina - An Esoteric Programming Language

# What is Ocarina?
Ocarina is a programming language heavily influenced by Python, Java, and Ruby. It includes single class inheritance and the ability to create nested
inner classes. It is an interpretted language that runs on a Java based interpretter (which means we can use the JVM for portability!). The design of
this language is meant to be simple in order to give first time language learners an easier time learning over something as wordy as Java. It's grammar
is fairly similar to MiniJava (a common language developed in compiler courses) except it is further developed.

All integers of any size and floats can be referenced by the same keyword. The interpretter shall handle any size fo integer or float that is thrown at
it. It also incluces a built in hashmap variable type due to the commonality of use of the data structure. 

This language is also unique in that it takes into account some programming aspects for quality analysts. This language shall eventually incluce built in
mocks and stubs in order more easily facilitate program testing enviroments so third party libraries do not have to be developed.

Ocarina is compiled with a JFlex lexer and JavaCUP parser. Source code is compiled to an intermediate representation that is then run on the Ocarina 
interpretter in a similar way to Java class files and the JVM.

# How do I compile an Ocarina file?
With the following command:

*ocarinac filename.oca*

This shall produce a file called filename.rina.

# Can I compile multiple files at once?
In later versions yes. For initial release, no.

# How do I run an Ocarina file?
With the following 

*ocarina filename.rina*

Progress report:
Revamp of Sytax development