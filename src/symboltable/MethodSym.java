package symboltable;
import ast.*;
import java.util.Hashtable;

public class MethodSym extends Sym{
	//Unsure how to handle arrays and hashmap return types
	public enum ReturnTypeEnum{
		INT, DECIMAL, BOOLEAN, STRING, ARRAY, HASHMAP, ID, FUNCTION, VOID;
	}
	public Hashtable<String, VarSym> varTable;
	public ReturnTypeEnum returnType;
	public Sym returnSym;	//If return type is ID or FUNCTION this is set

	public MethodSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, ReturnTypeEnum returnType){
		this.name = name;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
		this.protection = protection;
		this.returnType = returnType;
		this.varTable = new Hashtable<String, VarSym>();
		this.returnSym = null;
	}

	public MethodSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, ReturnTypeEnum returnType, Sym returnSym){
		this.name = name;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
		this.protection = protection;
		this.returnType = returnType;
		this.varTable = new Hashtable<String, VarSym>();
		this.returnSym = returnSym;
	}

	public void addVar(String name, VarSym symbol){
		varTable.put(name, symbol);
	}

	public VarSym getVar(String name){
		return varTable.get(name);
	}
}