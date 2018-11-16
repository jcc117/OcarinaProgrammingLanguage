package symboltable;
import ast.*;
import java.util.Hashtable;
import java.util.ArrayList;

//Represents a sage symbol
public class SageSym extends Sym{
	public Hashtable<String, SymbolTable> usingTable;
	public Hashtable<String, VarSym> varTable;
	public Hashtable<String, ClassSym> classTable;
	public Hashtable<String, Hashtable<String, MethodSym>> methodTable;	//Stored as a table of tables to allow for method overloading: outer key is method name, inner key is method signature
	public boolean hasMainMethod;;

	//Build a sage symbol
	public SageSym(String name, boolean hasMainMethod, Sym parent, String path){
		this.name = name;
		this.line = 0;
		this.column = 0;
		this.is_static = false;
		this.is_initialized = true;
		this.path = path;
		this.hasMainMethod = hasMainMethod;
		this.protection = ProtectionLevel.PUBLIC;
		this.usingTable = new Hashtable<String, SymbolTable>();
		this.varTable = new Hashtable<String, VarSym>();
		this.classTable = new Hashtable<String, ClassSym>();
		this.methodTable = new Hashtable<String, Hashtable<String, MethodSym>>();
		this.parent = parent;
	}

	//Add s symbol table to this sage: represents an imported sage
	public void addTable(String name, SymbolTable table){
		usingTable.put(name, table);
	}

	//Add a variable to the sage
	public void addVar(String name, VarSym symbol){
		varTable.put(name, symbol);
	}

	//Add a method to the sage
	public void addMethod(String signature, MethodSym symbol){
		int sigIndex = signature.indexOf("(");
		assert sigIndex != -1 : "Did not pass in proper method signature";
		String methodName = signature.substring(0, sigIndex);
		Hashtable<String, MethodSym> table = methodTable.get(methodName);
		if(table == null){
			methodTable.put(methodName, new Hashtable<String, MethodSym>());
			table = methodTable.get(methodName);
		}
		table.put(signature, symbol);
	}

	//Add a class to the sage
	public void addClass(String name, ClassSym symbol){
		classTable.put(name, symbol);
	}

	//Get the symbol table corresponding to an imported sage
	public SymbolTable getTable(String name){
		return usingTable.get(name);
	}

	//Get a variable by name
	public VarSym getVar(String name){
		return varTable.get(name);
	}

	//Get a method by signature
	public MethodSym getMethod(String signature){
		int sigIndex = signature.indexOf("(");
		if(sigIndex == -1){
			return null;	//Indicates a proper method signature was not passed in
		}
		String methodName = signature.substring(0, sigIndex);
		Hashtable<String, MethodSym> table = methodTable.get(methodName);
		if(table == null){
			return null;
		}
		return table.get(signature);
	}

	//Returns a table of methods whose signatures share the same method name
	public ArrayList<MethodSym> getMethodListByName(String name){
		Hashtable<String, MethodSym> table = methodTable.get(name);
		if(table == null){
			return null;
		}
		return (ArrayList<MethodSym>)table.values();
	}

	//Get a class by name
	public ClassSym getClass(String name){
		return classTable.get(name);
	}
}