// Ocarina compiler driver

import java.util.*;
import java.io.*;
import symboltable.*;

public class Ocarinac{
	public static void main(String args[]) throws IOException{
		// No args: Print options
		if(args.length == 0){
			System.out.println("No file provided");
			System.exit(-1);
		}

		FileReader sourceReader = new FileReader(new File(args[0]));
    	OcarinaLexer lexer = new OcarinaLexer(sourceReader);

    	parser _parser = new parser(lexer);
    	Symbol result = _parser.parse();

    	SymbolTableBuilder stb = new SymbolTableBuilder();
    	SymbolTable st = stb.build((Sage)result.value);
	}
}