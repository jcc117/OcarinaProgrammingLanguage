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
		int maxDegreeParallelism = 20;
		//Build abstract syntax trees and put them into the file catalog
		FileCatalogBuilder builder = new FileCatalogBuilder();
		FileCatalog fileCatalog = builder.build(args[0], maxDegreeParallelism);

    	//Do not continue if there were any errors in the input
    	if(!builder.hadErrors()){
    		OcarinaPrettyPrinter pretty_printer = new OcarinaPrettyPrinter();
    		for(int i = 0; i < fileCatalog.size(); i++){
    			pretty_printer.print(fileCatalog.get(i).getSage());
    		}

    		
    		for(int i = 0; i < fileCatalog.size(); i++){
    			SymbolTable table = new SymbolTable();
    			SymbolTableBuilderPass1 stBuilder = new SymbolTableBuilderPass1(table);
    			stBuilder.build(fileCatalog.get(i).getSage());
    		}
    	}
	}

}