package filecatalog;
import java_cup.runtime.*;
import java.util.*;
import java.io.*;
import ast.*;
import lexer_parser.*;

public class FileCatalogBuilder{
	private static ArrayList<Sage> fileCatalog = new ArrayList<Sage>();
	private static ArrayDeque<String> fileBackLog = new ArrayDeque<String>();

	public ArrayList<Sage> build(String filename) throws InterruptedException {
		Thread builder = new Thread(new AstBuilder(filename));
		builder.start();
		builder.join();
		return fileCatalog;
	}

	private class AstBuilder implements Runnable {
		public String filename;

		public AstBuilder(String filename){
			this.filename = filename;
		}
		public void run(){
			try{
				System.out.println("start thread");
				FileReader sourceReader = new FileReader(new File(filename));
		    	OcarinaLexer lexer = new OcarinaLexer(sourceReader);
		    	Symbol result = null;

	    		parser _parser = new parser(lexer);
	    		result = _parser.parse();

	    		addToCatalog((Sage)result.value);
	    		System.out.println("end thread");
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
		return fileBackLog.poll();
	}

	private synchronized void addToBackLog(String file){
		if(!fileBackLog.contains(file)){
			fileBackLog.offer(file);
		}
	}
}