// Ocarina compiler driver

import java.util.*;
import java.io.*;
import symboltable.*;
import ast.*;
import java_cup.runtime.*;
import java.math.*;

public class Ocarinac{
	public static void main(String args[]) throws IOException{
		// No args: Print options
		if(args.length == 0){
			System.out.println("No file provided");
			System.exit(-1);
		}

		FileReader sourceReader = new FileReader(new File(args[0]));
    	OcarinaLexer lexer = new OcarinaLexer(sourceReader);
    	Symbol result = null;

    	try{
    		parser _parser = new parser(lexer);
    		result = _parser.parse();
    	}
    	catch(Exception e){
    		System.out.println("Exited with errors");
    		System.out.println(e);
    		System.exit(-1);
    	}
    	//For testing purposes only
    	OcarinaPrettyPrinter pretty_printer = new OcarinaPrettyPrinter();
    	pretty_printer.print((Sage)result.value);
    	/*
    	SymbolTableBuilder stb = new SymbolTableBuilder();
    	SymbolTable st = stb.build((Sage)result.value);
    	ErrorChecker ec = new ErrorChecker();
    	if(ec.checkForErrors(result, st)){
    		
    	}*/
	}
}