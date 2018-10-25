*This guide is intended for advanced programmers. If you new to programming concepts please see BeginnersGuide*

# Programmers Guide to Ocarina
This is the quick and dirty version of picking up the basics of Ocarina. Since it is assumed you are an advanced programmer at this point I won't go into 
the details proramming basics. What Ocarina implements is fairly standard, and only some of the specific features unique to Ocarina will be discussed in detail. Instead,
only brief descriptions of syntax will be given so you have an idea of where to start. Let's start with the basics 

# The Basics

The basic file structure of a basic Ocarina file(postfixed .ocar) can be seen below. Note that single-line comments in Ocarina are denoted by '#'.
Multi-line comments are denoted with '''. All statements must end with ';'.

	sage filename;
	# Any file imports go here
	# Execution begins here
	start
		'''
		Code goes here
		'''
	end
	# Definitions of classes, functions, and other variables go here

The first line of any Ocarina file is denoted by the keyword 'sage' followed by the name of the file. What a sage is and how they are structured will be covered later. 
The beginning of execution (the main function) for any Ocarina starts after the 'start' keyword and continues until the properly nested 'end' 
keyword is encountered. Not all Ocarina files are required to have a main function. These types of files can be imported to files that do contain one.
Below is an example of an example of a file that does not contain a main function and a file that imports that file. Note file imports are denoted by
the 'using' keyword.

	sage file1;
	# This file only contains class definitions, functions, and variables.
	# More detail on these will be covered below
	public class Example
		# Class code goes here
	end

	sage file2;
	using file1;	# Note this denotes the location of the file
	using folder.file3; # This file's path is relative to the current files
	start
		# Various code
	end

The structure of an Ocarina can be summarized as follows:
1. 	Sage Declariation
2.	File Imports
3.	(Optional) Main function
4.	Class Declarations, Function Declarations, Variable Declarations

There is no particular order to the last section. They can be declared in any order that the user chooses. For example, you may declare a
variable, a class, a function, then another variable in that order. However, the Ocarina convention is:
1. 	Variable Declarations
2.	Function Declarations
3.	Class Declarations

You are not required to follow this convention, but it is recommended that you do so to maintain orderly code.	

# Variables and Types
*Basic Types*

	int
	decimal
	boolean
	string
	array
	hashmap
	function

*Class Initialization*

*var type*

*Protection Levels*

# Conditionals and Loops
*Evaluating Conditionals*
*if statements*
*unless statements*
*while loops*
*until loops*
*do-while loops*
*for loops*
*foreach loops*

# Expressions

# Functions

# Anonymous Functions

# Classes
*Inheritance*
*Static Classes*
*Class Nesting*

# Exceptions

# Sages
Sages are the equivalent of packages in Java and namespaces in C#. Why are they called sages? For the same reason this language is called Ocarina. Irreverancy. The main 
difference between sages and those afforementioned items is you can have subroutines be directly tied to sages. All code must be included in a sage, including the main 
subroutine. You can import other sages using the 'using' keyword. Sages must be the first item declared in a file, followed by your import list. Sages can be carried across
multiple files. Only one main subroutine may be declared in any sage, and you may not import another sage if it contains a main subroutine.

	sage fire;
	using rupee;
	using hookshot;
	start
		...
	end
	...

# Running An Ocarina Program