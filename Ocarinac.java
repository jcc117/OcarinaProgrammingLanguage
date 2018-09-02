// Ocarina compiler driver

import java.util.*;
import java.io.*;
import symboltable.*;
import ast.*;
import java_cup.runtime.*;
import java.math.*;

public class Ocarinac{
	private ArrayList<Sage> fileCatalog = new ArrayList<Sage>();
	private ArrayDeque<String> fileBackLog = new ArrayDeque<String>();

	public static void main(String args[]) throws IOException, InterruptedException{
		// No args: Print options
		if(args.length == 0){
			System.out.println("No file provided");
			System.exit(-1);
		}

		Thread builder = new Thread(new AstBuilder(args[0]));
		builder.start();
		builder.join();

    	//For testing purposes only
    	OcarinaPrettyPrinter pretty_printer = new OcarinaPrettyPrinter();
    	pretty_printer.print(fileCatalog.get(0));
    	/*
    	SymbolTableBuilder stb = new SymbolTableBuilder();
    	SymbolTable st = stb.build((Sage)result.value);
    	ErrorChecker ec = new ErrorChecker();
    	if(ec.checkForErrors(result, st)){
    		
    	}*/
	}

	private class AstBuilder implements Runnable {
		public String filename;

		public AstBuilder(String filename){
			this.filename = filename;
		}
		public void run(){
			try{
				FileReader sourceReader = new FileReader(new File(filename));
		    	OcarinaLexer lexer = new OcarinaLexer(sourceReader);
		    	Symbol result = null;

	    		parser _parser = new parser(lexer);
	    		result = _parser.parse();

	    		addToCatalog((Sage)result);
	    	}
	    	catch(IOException d){
	    		System.out.println("Invalid file");
	    	}
	    	catch(Exception e){
	    		System.out.println("Exited with errors");
	    		System.out.println(e);
	    		System.exit(-1);
	    	}
		}
	}

	private synchronized void addToCatalog(Sage result){
		if(!fileCatalog.contains(result)){
			fileCatalog.add(result);
		}
	}

	private synchronized String grabFileToProcess(){
		fileBackLog.poll();
	}

	private synchronized void addToBackLog(String file){
		if(!fileBackLog.contains(file)){
			fileBackLog.offer(file);
		}
	}
}