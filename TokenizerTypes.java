//For use with Testing the Lexer

public interface TokenizerTypes{
	/* Keywords */
	public static final int START = 1;
	public static final int  END = 2;
	public static final int CLASS = 3;
	public static final int EXTENDS = 4;
	public static final int SUBROUTINE = 5;
	public static final int MOCK = 6;
	public static final int STUB = 7;
	public static final int VOID = 8;
	public static final int INT = 9;
	public static final int FLOAT = 10;
	public static final int BOOLEAN = 11;
	public static final int HASHMAP = 12;
	public static final int STRING = 13;
	public static final int BEGIN = 14;
	public static final int IF = 15;
	public static final int RATHER = 16;
	public static final int ELSE = 17;
	public static final int WHILE = 18;
	public static final int RETURN = 19;
	public static final int AND = 20;
	public static final int OR = 21;
	public static final int NAND = 22;
	public static final int NOR = 23;
	public static final int TRUE = 24;
	public static final int FALSE = 25;
	public static final int EQUALS = 26;
	public static final int THIS = 27;
	public static final int NIL = 28;
	public static final int ASSERT = 29;
	public static final int CREATE = 30;
	public static final int GETINT = 31;
	public static final int GETFLOAT = 32;
	public static final int GETSTRING = 33;
	public static final int GETBOOLEAN = 34;
	public static final int EXIT = 35;
	public static final int ARRAY = 36;
	public static final int LENGTH = 37;
	public static final int PRINT = 38;
	public static final int DEBUG = 39;
	public static final int BREAK = 40;
	public static final int CONTINUE = 41;
	public static final int SAGE = 42;
	public static final int FOR = 43;
	public static final int DO = 44;
	public static final int USING = 45;
	public static final int PUBLIC = 46;
	public static final int PRIVATE = 47;
	public static final int PROTECTED = 48;
	public static final int CONSTRUCTOR = 49;

	/* Operators */
	public static final int INCREMENT = 50;
	public static final int DECREMENT = 51;
	public static final int POINTER = 52;
	public static final int BANG = 53;
	public static final int PLUS = 54;
	public static final int MINUS = 55;
	public static final int MULT = 56;
	public static final int POWER = 57;
	public static final int DIV = 58;
	public static final int GTHANE = 59;
	public static final int LTHANE = 60;
	public static final int LTHAN = 61;
	public static final int GTHAN = 62;
	public static final int EQUAL = 63;
	public static final int LBRACKET = 64;
	public static final int RBRACKET = 65;
	public static final int LBRACE = 66;
	public static final int RBRACE = 67;
	public static final int LPAREN = 68;
	public static final int RPAREN = 69;
	public static final int DOT = 70;
	public static final int SEMICOLON = 71;
	public static final int AT = 72;
	public static final int COMMA = 73;
	public static final int MOD = 74;
	public static final int INTLITERAL = 75;
	public static final int FLOATLITERAL = 76;
	public static final int STRINGLITERAL = 77;
	public static final int IDENTIFIER = 78;
	public static final int COLON = 79;

	public static final int EOF = -1;
}