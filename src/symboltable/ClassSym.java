package symboltable;
import ast.*;
import java.util.Hashtable;

public class ClassSym extends Sym{
	public Hashtable<String, VarSym> varTable;
	public Hashtable<String, MethodSym> methodTable;
	public Hashtable<String, ClassSym> classTable;
	public Hashtable<String, MethodSym> constructorTable;
	public ClassSym extension;

	public ClassSym(String name, int line, int column, boolean is_static, ProtectionLevel protection){
		this.is_initialized = true;
		this.name = name;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
		this.protection = protection;
		this.varTable = new Hashtable<String, VarSym>();
		this.methodTable = new Hashtable<String, MethodSym>();
		this.classTable = new Hashtable<String, ClassSym>();
		this.constructorTable = new Hashtable<String, MethodSym>();
	}

	public ClassSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, ClassSym extension){
		this.is_initialized = true;
		this.name = name;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
		this.protection = protection;
		this.extension = extension;
		this.varTable = new Hashtable<String, VarSym>();
		this.methodTable = new Hashtable<String, MethodSym>();
		this.classTable = new Hashtable<String, ClassSym>();
		this.constructorTable = new Hashtable<String, MethodSym>();
	}

	public void addVar(String name, VarSym symbol){
		varTable.put(name, symbol);
	}

	public void addMethod(String name, MethodSym symbol){
		methodTable.put(name, symbol);
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

	public MethodSym getMethod(String name){
		return methodTable.get(name);
	}

	public ClassSym getClass(String name){
		return classTable.get(name);
	}

	public MethodSym getConstructor(String name){
		return constructorTable.get(name);
	}
}