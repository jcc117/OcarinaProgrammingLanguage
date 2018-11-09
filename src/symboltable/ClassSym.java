package symboltable;
import ast.*;
import java.util.Hashtable;
import java.util.ArrayList;

public class ClassSym extends Sym{
	public Hashtable<String, VarSym> varTable;
	public Hashtable<String, Hashtable<String, MethodSym>> methodTable;	//Stored as a table of tables to allow for method overloading: outer key is method name, inner key is method signature
	public Hashtable<String, ClassSym> classTable;
	public Hashtable<String, MethodSym> constructorTable;
	public ClassSym extension;

	public ClassSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, Sym parent, String path){
		this.is_initialized = true;
		this.name = name;
		this.line = line;
		this.path = path;
		this.column = column;
		this.is_static = is_static;
		this.protection = protection;
		this.parent = parent;
		this.varTable = new Hashtable<String, VarSym>();
		this.methodTable = new Hashtable<String, Hashtable<String, MethodSym>>();
		this.classTable = new Hashtable<String, ClassSym>();
		this.constructorTable = new Hashtable<String, MethodSym>();
	}

	public ClassSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, Sym parent, String path, ClassSym extension){
		this.is_initialized = true;
		this.name = name;
		this.line = line;
		this.column = column;
		this.path = path;
		this.is_static = is_static;
		this.protection = protection;
		this.extension = extension;
		this.parent = parent;
		this.varTable = new Hashtable<String, VarSym>();
		this.methodTable = new Hashtable<String, Hashtable<String, MethodSym>>();
		this.classTable = new Hashtable<String, ClassSym>();
		this.constructorTable = new Hashtable<String, MethodSym>();
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

	public void addClass(String name, ClassSym symbol){
		classTable.put(name, symbol);
	}

	public void addConstructor(String name, MethodSym symbol){
		constructorTable.put(name, symbol);
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

	public ClassSym getClass(String name){
		return classTable.get(name);
	}

	public MethodSym getConstructor(String name){
		return constructorTable.get(name);
	}
}