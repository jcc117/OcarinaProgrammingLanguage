// Ocarina compiler driver

import java.util.*;
import java.io.*;
import symboltable.*;
import ast.*;
import lexer_parser.*;
import filecatalog.*;
import java_cup.runtime.*;
import java.math.*;

public class Ocarinac{

	public static void main(String args[]) throws IOException, InterruptedException{
		// No args: Print options
		if(args.length == 0){
			System.out.println("No file provided");
			System.exit(-1);
		}

		FileCatalogBuilder builder = new FileCatalogBuilder();
		ArrayList<Sage> fileCatalog = builder.build(args[0]);

    	//For testing purposes only
    	OcarinaPrettyPrinter pretty_printer = new OcarinaPrettyPrinter();
    	pretty_printer.print(fileCatalog.get(0));
	}

}