package filecatalog;
import java_cup.runtime.*;
import java.util.*;
import java.io.*;
import ast.*;
import lexer_parser.*;

public class FileCatalogBuilder{
	private static FileCatalog fileCatalog = new FileCatalog();
	private static ArrayDeque<String> fileBackLog = new ArrayDeque<String>();	//Its better to make this an array of Files
	private static ArrayList<String> inProcessing = new ArrayList<String>();	//Its better to make this an array of Files
	private boolean hadError;

	public FileCatalog build(String filename) throws InterruptedException {
		hadError = false;
		//Run the initial file
		Thread builder = new Thread(new AstBuilder(filename));
		builder.start();
		builder.join();
		//Build any imports
		ArrayList<String> usings = fileCatalog.get(0).getSage().getUsings();

		// Create files here and add them to the back log
		for(String s : usings){
			System.out.println(s);	//For testing purposes only
			addToBackLog(s);	//Change this to create a file instead
		}

		//Process remaining imports
		/*while(!fileBackLog.isEmpty()){
			//Create a new thread for each item and process it
			ArrayList<Thread> builders = new ArrayList<Thread>();
			while(!fileBackLog.isEmpty()){
				builders.add(new Thread(new AstBuilder(fileBackLog.getFirst())));
				inProcessing.add(fileBackLog.poll());	//What if the paths differ but they point to files that were already processed?
			}

			//Run the threads
			for(Thread t : builders){
				t.run();
				t.join();
			}

			//Get the new items, look at their imports, and add them to the file backlog

			//Add those files to the file catalog
		}*/

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

	    		addToCatalog(new CatalogItem((Sage)result.value));
	    		System.out.println("end thread");
	    	}
	    	catch(IOException d){
	    		System.out.println("Unable to process " + filename);
	    		hadError = true;
	    	}
	    	catch(Exception e){
	    		System.out.println("Exited with errors");
	    		System.out.println(e);
	    		hadError = true;
	    	}
		}
	}

	private synchronized void addToCatalog(CatalogItem result){
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

	public boolean hadErrors(){
		return hadError;
	}
}