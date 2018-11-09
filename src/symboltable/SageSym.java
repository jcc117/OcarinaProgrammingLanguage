package symboltable;
import ast.*;
import java.util.Hashtable;
import java.util.ArrayList;

public class SageSym extends Sym{
	public Hashtable<String, SymbolTable> usingTable;
	public Hashtable<String, VarSym> varTable;
	public Hashtable<String, ClassSym> classTable;
	public Hashtable<String, Hashtable<String, MethodSym>> methodTable;	//Stored as a table of tables to allow for method overloading: outer key is method name, inner key is method signature
	public Hashtable<String, MethodSym> methodLiteralTable;
	public boolean hasMainMethod;
	public Hashtable<String, VarSym> mainMethodVarTable;

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
		if(this.hasMainMethod){
			this.mainMethodVarTable = new Hashtable<String, VarSym>();
		}
		else{
			this.mainMethodVarTable = null;
		}
		this.parent = parent;
	}

	public void addTable(String name, SymbolTable table){
		usingTable.put(name, table);
	}

	public void addVar(String name, VarSym symbol){
		varTable.put(name, symbol);
	}

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

	public void addMethodLiteral(String name, MethodSym symbol){
		methodLiteralTable.put(name, symbol);
	}

	public void addClass(String name, ClassSym symbol){
		classTable.put(name, symbol);
	}

	public void addMainMethodVar(String name, VarSym var){
		if(mainMethodVarTable != null)
			mainMethodVarTable.put(name, var);
	}

	public SymbolTable getTable(String name){
		return usingTable.get(name);
	}

	public VarSym getVar(String name){
		return varTable.get(name);
	}

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

	public MethodSym getMethodLiteral(String name){
		return methodLiteralTable.get(name);
	}

	public ClassSym getClass(String name){
		return classTable.get(name);
	}

	public VarSym getMainMethodVar(String name){
		if(mainMethodVarTable == null)
			return null;
		return mainMethodVarTable.get(name);
	}
}