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
	private static ArrayList<String> processed = new ArrayList<String>();
	private boolean hadError;

	public FileCatalog build(String filename) throws InterruptedException {
		hadError = false;
		//Run the initial file
		File initialFile = new File(filename);
		Thread builder = new Thread(new AstBuilder(initialFile));
		builder.start();
		builder.join();
		addToProcessed(initialFile.getAbsolutePath());

		//Build any imports
		if(fileCatalog.size() == 0){
			System.exit(-1);
		}
		ArrayList<String> usings = fileCatalog.get(0).getSage().getUsings();
		String sageName = fileCatalog.get(0).getSage().i.i;
		String name = initialFile.getName();

		//Ensure the sage name matches the file name
		if(!name.equals(sageName  + ".ocar")){
			System.out.println(name);
			System.out.println("Ocarina Error: Sage name \"" + sageName + "\" does not match file name");
			System.exit(-1);	//Temporary
		}

		//Create the basepath for other files to latch onto
		String basePath = initialFile.getAbsolutePath();
		basePath = basePath.replace(sageName + ".ocar", "");

		/****************************************************
		To Do
		Add error statements for sage names not matching file names
		Fix base paths for all future files to process
		*******************************************************/

		// Create files here and add them to the back log
		for(String s : usings){
			addToBackLog(basePath + s);	//Change this to create a file instead
			System.out.println(basePath + s);
		}

		//Process remaining imports
		while(!fileBackLog.isEmpty()){
			for(String k : fileBackLog){
				System.out.println("in backlog => " + k);
			}

			//Create a new thread for each item and process it
			ArrayList<Thread> builders = new ArrayList<Thread>();
			while(!fileBackLog.isEmpty()){
				File fileToProcess = new File(fileBackLog.poll());
				builders.add(new Thread(new AstBuilder(fileToProcess)));
				inProcessing.add(fileToProcess.getAbsolutePath());
			}

			//Run the threads
			for(Thread t : builders){
				t.run();
				t.join();
			}

			//Get the new items, look at their imports, and add them to the file backlog
			for(int i = 0; i < fileCatalog.size(); i++){
				CatalogItem ci = fileCatalog.get(i);
				String innerBasePath = ci.getPath();
				sageName = ci.getName();
				File temp = new File(innerBasePath);
				filename = temp.getName();
				if(!filename.equals(sageName + ".ocar")){
					System.out.println("Ocarina Error: Sage name \"" + sageName + "\" does not match file name");
					System.exit(-1);	//Temporary
				}
				temp = null;
				innerBasePath = innerBasePath.replace(sageName + ".ocar", "");

				ArrayList<String> usingList = fileCatalog.get(i).getSage().getUsings();
				for(int j = 0; j < usingList.size(); j++){
					//Get the absolute path for the file
					String path = innerBasePath + usingList.get(j);
					//Don't add the file to the backlog if it is already in there or it was already processed
					if(!fileBackLog.contains(path) && !processed.contains(path)){
						addToBackLog(path);
					}
				}
			}
		}

		return fileCatalog;
	}

	private class AstBuilder implements Runnable {
		public File filename;

		public AstBuilder(File filename){
			this.filename = filename;
		}
		public void run(){
			try{
				//Check for file extension
				String path = filename.getAbsolutePath();
				if(path.length() < 6)
				{
					throw new Exception();
				}

				String extension = path.substring(path.length() - 5);
				if(!extension.equals(".ocar")){
					System.out.println(extension);
					System.out.println("Invalid file type: file at " + path + " does not have .ocar file extension");
					hadError = true;
					addToProcessed(path);
				}
				else{
					//System.out.println("Processing " + filename + "...");
					FileReader sourceReader = new FileReader(filename);
			    	OcarinaLexer lexer = new OcarinaLexer(sourceReader);
			    	Symbol result = null;

		    		parser _parser = new parser(lexer);
		    		result = _parser.parse();

		    		addToCatalog(new CatalogItem((Sage)result.value, ((Sage)result.value).i.i, path));
		    		addToProcessed(path);
		    		//System.out.println("Done processing " + filename);
		    	}
	    	}
	    	catch(IOException d){
	    		System.out.println("Unable to process " + filename.getAbsolutePath());
	    		addToProcessed(filename.getAbsolutePath());
	    		hadError = true;
	    	}
	    	catch(Exception e){
	    		System.out.println("Errors occurred when processing" + filename.getAbsolutePath());
	    		addToProcessed(filename.getAbsolutePath());
	    		System.out.println(e);
	    		hadError = true;
	    	}
		}
	}

	private synchronized void addToProcessed(String path){
		if(!processed.contains(path)){
			processed.add(path);
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