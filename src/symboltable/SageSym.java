package symboltable;
import ast.*;
import java.util.HashMap;

public class SageSym extends Sym{
	public int line;
	public String name;
	public HashMap<String, Sym> defTable;	//Associated classes, functions, and exceptions
	public HashMap<String, SageSym> usingTable;	//Associated sages

	public SageSym(int line, String name){
		this.line = line;
		this.name = name;
		defTable = new HashMap<String, Sym>();
		usingTable = new HashMap<String, SageSym>();
	}

	public void put(String name, Sym sym){
		defTable.put(name, sym);
	}

	public void put(String name, SageSym sym){
		usingTable.put(name, sym);
	}

	public Sym lookUpDef(String name){
		return defTable.get(name);
	}

	public SageSym lookUpSage(String name){
		return usingTable.get(name);
	}
}