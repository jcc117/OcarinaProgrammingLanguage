//Used for testing functionality of the lexer

import java.io.*;
import java_cup.runtime.Symbol;
import java.math.*;

public class Tokenizer
{
	public static void main(String[] args) throws IOException, Exception
	{
		//Open the file to lex
		if(args.length != 1)
		{
			System.out.println("Wrong number of arguments.");
			System.exit(-1);
		}

		String filename = args[0];
		FileInputStream stream = new FileInputStream(filename);
		InputStreamReader reader = new InputStreamReader(stream);
		java_cup.runtime.Scanner lexer = new OcarinaLexerTokenizer(reader);

		System.out.println("Line\t\tColumn\t\tToken\t\t\tValue");
		System.out.println("==========================================================");

		//Set up tokenizer loop
		Symbol token = lexer.next_token();
		boolean flag = false;
		while(token != null)
		{
			int line = token.left;
			int column = token.right;
			int tok = token.sym;
			String value = null;

			//Format token to the correct string
			String tokString = new String();
			switch (tok){
				case 1:
					tokString = "START";
					break;
				case 2:
					tokString = "END";
					break;
				case 3:
					tokString = "CLASS";
					break;
				case 4:
					tokString = "EXTENDS";
					break;
				case 5:
					tokString = "SUBROUTINE";
					break;
				case 6:
					tokString = "MOCK";
					break;
				case 7:
					tokString = "STUB";
					break;
				case 8:
					tokString = "VOID";
					break;
				case 9:
					tokString = "INT";
					break;
				case 10:
					tokString = "FLOAT";
					break;
				case 11:
					tokString = "BOOLEAN";
					break;
				case 12:
					tokString = "HASHMAP";
					break;
				case 13:
					tokString = "STRING";
					break;
				case 14:
					tokString = "BEGIN";
					break;
				case 15:
					tokString = "IF";
					break;
				case 16:
					tokString = "RATHER";
					break;
				case 17:
					tokString = "ELSE";
					break;
				case 18:
					tokString = "WHILE";
					break;
				case 19:
					tokString = "RETURN";
					break;
				case 20:
					tokString = "AND";
					break;
				case 21:
					tokString = "OR";
					break;
				case 22:
					tokString = "NAND";
					break;
				case 23:
					tokString = "NOR";
					break;
				case 24:
					tokString = "TRUE";
					break;
				case 25:
					tokString = "FALSE";
					break;
				case 26:
					tokString = "EQUALS";
					break;				
				case 27:
					tokString = "THIS";
					break;
				case 28:
					tokString = "NIL";
					break;
				case 29:
					tokString = "ASSERT";
					break;
				case 30:
					tokString = "CREATE";
					break;
				case 31:
					tokString = "GETINT";
					break;
				case 32:
					tokString = "GETFLOAT";
					break;
				case 33:
					tokString = "GETSTRING";
					break;
				case 34:
					tokString = "GETBOOLEAN";
					break;
				case 35:
					tokString = "EXIT";
					break;
				case 36:
					tokString = "ARRAY";
					break;
				case 37:
					tokString = "LENGTH";
					break;
				case 38:
					tokString = "PRINT";
					break;
				case 39:
					tokString = "DEBUG";
					break;
				case 40:
					tokString = "BREAK";
					break;
				case 41:
					tokString = "CONTINUE";
					break;
				case 42:
					tokString = "SAGE";
					break;
				case 43:
					tokString = "FOR";
					break;
				case 44:
					tokString = "DO";
					break;
				case 45:
					tokString = "USING";
					break;
				case 46:
					tokString = "PUBLIC";
					break;
				case 47:
					tokString = "PRIVATE";
					break;
				case 48:
					tokString = "PROTECTED";
					break;
				case 49:
					tokString = "CONSTRUCTOR";
					break;
				case 50:
					tokString = "INCREMENT";
					break;
				case 51:
					tokString = "DECREMENT";
					break;
				case 52:
					tokString = "POINTER";
					break;
				case 53:
					tokString = "BANG";
					break;
				case 54:
					tokString = "PLUS";
					break;
				case 55:
					tokString = "MINUS";
					break;
				case 56:
					tokString = "MULT";
					break;
				case 57:
					tokString = "POWER";
					break;
				case 58:
					tokString = "DIV";
					break;
				case 59:
					tokString = "GTHANE";
					break;
				case 60:
					tokString = "LTHANE";
					break;
				case 61:
					tokString = "GTHAN";
					break;
				case 62:
					tokString = "LTHAN";
					break;
				case 63:
					tokString = "EQUAL";
					break;
				case 64:
					tokString = "LBRACKET";
					break;
				case 65:
					tokString = "RBRACKET";
					break;
				case 66:
					tokString = "LBRACE";
					break;
				case 67:
					tokString = "RBRACE";
					break;
				case 68:
					tokString = "LPAREN";
					break;
				case 69:
					tokString = "RPAREN";
					break;
				case 70:
					tokString = "DOT";
					break;
				case 71:
					tokString = "SEMICOLON";
					break;
				case 72:
					tokString = "AT";
					break;
				case 73:
					tokString = "COMMA";
					break;
				case 74:
					tokString = "MOD";
					break;
				case 75:
					tokString = "INTLITERAL";	//------------------------------------
					BigInteger temp = (BigInteger)token.value;
					value = temp.toString();
					break;
				case 76:
					tokString = "FLOATLITERAL";
					BigDecimal temp2 = (BigDecimal)token.value;
					value = temp2.toString();
					break;
				case 77:
					tokString = "STRINGLITERAL";
					value = (String)token.value;
					break;
				case 78:
					tokString = "IDENTIFIER";	//-----------------------------------
					value = (String)token.value;
					break;
				case 79:
					tokString = "COLON";
					break;
				case -1:
					System.out.println("EOF");
					flag = true;
					break;														
			}
			if(flag)
				token = null;
			else
				token = lexer.next_token();
			if(value != null && !flag)
				System.out.println((line+1) + "\t\t" + (column + 1) + "\t\t" + tokString + "\t\t\t" + value);
			else if(!flag)
				System.out.println((line+1) + "\t\t" + (column + 1) + "\t\t" + tokString);
		}//End while
	}
}