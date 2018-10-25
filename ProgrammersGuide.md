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

Here's a file that imports the one above.
	
	sage file2;
	using file1;	# Note this denotes the location of the file
	using folder.file3; # The file's path is relative to the current file's
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

## Variable Naming Conventions
All variable names, function names, and class names follow this structure
* The first character must be a letter (lower or upper case) or '_'
* All preceding characters may contain a letter, number, '\_', or '?''

The following are examples of valid names.
* a
* abcde
* abc123
* \_ab4d
* this_is_a_variable?
* yes\_?\_no

The following are examples of invalid names.
* 1
* 123abc
* ?names
* ^^%5


Names are case sensitive. For example, 'variable_name' and 'VARIABLE_NAME' are considered completely different items.

## Basic Types

Ocarina is a strongly typed language, therefore stating the type of a variable is required when declaring them. Below are the basic variable types.

* int
* decimal
* boolean
* string
* array
* hashmap
* function

Variables do not have to be immediately assigned upon creation.

### int
An int can be used for any integer. There is no limit on how large or small this number is. Below is are examples of int delcarations and valid assignments.

	int x = 5;
	int y = 0123;	# This is an octal number
	int z = 0xabc123;	# This is a hexadecimal number. 'x' or 'X' can be used.
	int large_number = 123456789123456789123456789;
	int negative_number = -5;

### decimal
A decimal can be used for any numbers that have floating point values. There is no size limit for these numbers. You may assign an 'int' to a variable
of type decimal, but it will be treated as a decimal number. Declaring decimal numbers to ints results in the floating put digits being truncated

	decimal num = 1.5;
	decimal another = -1.5;
	decimal big_number = 204823048208.20480482048208048320420423048204;
	decimal whole_number = 5; # This evaluates to 5.0
	int truncated_number = 5.666667; # This will not cause an error, but the number will be truncated to 5


### boolean
Booleans are true/false variables that can only be assigned true, false, or an expression that evaluates to true or false.
	
	boolean value? = true;
	boolean another? = false;

Note that the naming convention for boolean variables has them ending in '?'.

### string
Strings are strings of characters that denoted by "" or ''. They may be of any length. Strings are editable and when edited do not result in new strings
being created.

	string first = "I love programming!";
	string second = "I" + " love " + "programming"; # This string is concatenated together

### array
Arrays types are denoted with a type followed by [];
	
	int[] numbers = create int[5]; # creates an array of length 5
	string[][] twoDArray = create string[9][8];	# creates a 2-d array. Note that the length must be specified for all dimensions
	boolean[] literal = create boolean[] { true, false, true, true, false};	# creates a boolean array of literals

### hashmap
Hashmaps work on a key-value basis. The following are uses of the hashmap variable.
	
	hashmap{int, string} map = hashmap{int, string}; # Declares a hashmap whose key is of type int and value is of type string.
	hashmap{int[], boolean} different; # Key is an int array, value it returns is boolean
	map{5} = "assignment"; # Assigns the string to the key 5
	string value = map{5}; # Returns the value associated with the key 5, which is "assignment"

### function
In Ocarina, functions be declared and assigned to variables. The following is are examples of function variable declarations. Return types are specified
within the brackets.

	function{int} b;	# A function that returns an int
	function{string[]} c;	# A function that returns an array of strings
	function{function{decimal}} nested_function;	# A function that returns a function that returns a decimal

More will be covered on how to assign these variables in the 'Anonymous Functions' section.

## Class Initialization
Classes can be initiated in the following way:
	
	Example ex = create Example(); # Creates an instance of the Example class

More detail on classes will be covered in the 'Classes' section.

## var type
Var variables are shortcuts for assigning variables. Instead of stating the type of the variable, Ocarina will be able to determine it at compile time.
However, you they must be assigned immediate after declaration, and they can only be used within the main function and other functions.
	
	var x = true; # x is a boolean variable
	var y = 5.55; # y is a decimal
	var arr = create string[100]; # arr is an array o strings
	var illegal; # this is illegal and will cause an error
	var another_illegal = nil;	# illegal - cannot distinguish type from nil
	var third_illegal = null;	# nil an null are the same thing in Ocarina

Var declarations do not just have to be literals. They can be evaluated from expressions, which will be covered in the 'Expressions' section.

# Expressions

# Conditionals and Loops

## if statements
## unless statements
## while loops
## until loops
## do-while loops
## for loops
## foreach loops

# Functions

# Anonymous Functions

# Classes
## Inheritance
## Static Classes
## Class Nesting

# Exceptions

# Protection Levels

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