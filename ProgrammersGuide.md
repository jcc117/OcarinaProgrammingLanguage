*This guide is intended for advanced programmers. If you new to programming concepts please see BeginnersGuide*

# Programmers Guide to Ocarina
This is the quick and dirty version of picking up the basics of Ocarina. Since it is assumed you are an advanced programmer at this point I won't go into 
the details proramming basics. What Ocarina implements is fairly standard, and only some of the specific features unique to Ocarina will be discussed in detail. Instead,
only brief descriptions of syntax will be given so you have an idea of where to start. Let's start with the basics 

# The Basics

# Variables and Types
*Basic Types*

	int
	decimal
	boolean
	string
	array
	hashmap
	function{_type_}

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

# Classes
*Inheritance*
*Singleton Classes*
*Class Nesting*

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

# Debug Mode
Debug mode is a special feature to the Ocarina interpreter.