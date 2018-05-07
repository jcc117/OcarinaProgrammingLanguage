import java_cup.runtime.*;

%%

%class OcarinaLexer
%extends sym
%cup
%line
%column

%eofval{
	return symbol(EOF);
%eofval}

%{
	private Symbol symbol(int type) {
    	return new Symbol(type, yyline + 1, yycolumn + 1);
    }

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline + 1, yycolumn + 1, value);
	}
%}

IntegerLiteral = {DecimalLiteral} | {HexLiteral} | {OctalLiteral}
DecimalLiteral = [1-9][0-9]*
HexLiteral = 0[Xx][0-9A-Fa-f]*
OctalLiteral = 0[0-7]*
FloatLiteral = [+-]?([0-9]*[.])?[0-9]+
Identifier = (a-zA-Z_)(a-zA-Z0-9_?)*
LineComment = #[^\n]*\n?
BlockComment = \'\'\'.*\'\'\'
WhiteSpace = [\t\n\r]+

%%

/*Keywords*/
"start" {return symbol(START);}
"end"	{return symbol(END);}
"class"	{return symbol(CLASS);}
"endclass"	{return symbol(ENDCLASS);}
"extends"	{return symbol(EXTENDS);}
"subroutine"	{return sybmol(SUBROUTINE);}
"endsubr"	{return symbol(ENDSUBR);}
"mock"	{return symbol(MOCK);}
"endmock"	{return symbol(ENDMOCK);}
"stub"	{return symbol(STUB);}
"endstub"	{return symbol(ENDSTUB);}
"void"	{return symbol(VOID);}
"int"	{return symbol(INT);}
"float"	{return symbol(FLOAT);}
"boolean"	{return symbol(BOOLEAN);}
"hashmap"	{return symbol(HASHMAP);}
"string"	{return symbol(STRING);}
"if"	{return symbol(IF);}
"else"	{return symbol(ELSE);}
"endif"	{return symbol(ENDIF);}
"while"	{return symbol(WHILE);}
"endwhile"	{return symbol(ENDWHILE);}
"return"	{return symbol(RETURN);}
"and"	{return symbol(AND);}
"or"	{return symbol(OR);}
"nand"	{return symbol(NAND);}
"nor"	{return symbol(NOR);}
"true"	{return symbol(TRUE);}
"false"	{return symbol(FALSE);}
"equals"	{return symbol(EQUALS);}
"this"	{return symbol(THIS);}
"nil"	{return symbol(NIL);}
"assert"	{return symbol(ASSERT);}
"create"	{return symbol(CREATE);}

/*Operators*/
"->"	{return symbol(POINTER);}
"!"	{return symbol(BANG);}
"+"	{return symbol(PLUS);}
"-"	{return symbol(MINUS);}
"*"	{return symbol(MULT);}
"^"	{return symbol(POWER);}
"/"	{return symbol(DIV);}
">="	{return symbol(GTHANE);}
"<="	{return symbol(LTHANE);}
"<"	{return symbol(LTHAN);}
">"	{return symbol(GTHAN);}
"="	{return symbol(EQUAL);}
"["	{return symbol(LBRACKET);}
"]"	{return symbol(RBRACKET);}
"{"	{return symbol(LBRACE);}
"}"	{return symbol(RBRACE);}
"."	{return symbol(DOT);}
";"	{return symbol(SEMICOLON);}
":"	{return symbol(COLON);}
"@"	{return symbol(AT);}
"," {return symbol(COMMA);}

/*Identifiers and numbers*/
{Identifier}	{return symbol(IDENTIFIER);}
{IntegerLiteral}	{return symbol(INTLITERAL);}
{FloatLiteral}	{return symbol(FLOATLITERAL);}

/*To be ignored*/
{LineComment}	{/*Do nothing*/}
{BlockComment}	{/*Do nothing*/}
{WhiteSpace}	{/*Do nothing*/}

[^]	{/*Return an error message*/}