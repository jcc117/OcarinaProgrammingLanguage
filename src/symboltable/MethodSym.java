package symboltable;
import ast.*;
import java.util.Hashtable;

public class MethodSym extends Sym{
	//Unsure how to handle returning functions
	public enum ReturnTypeEnum{
		INT, DECIMAL, BOOLEAN, STRING, ARRAY, HASHMAP, ID, FUNCTION, VOID;
	}
	public Hashtable<String, VarSym> varTable;
	public ReturnTypeEnum returnType;

	public MethodSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, ReturnTypeEnum returnType){
		this.name = name;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
		this.protection = protection;
		this.returnType = returnType;
		this.varTable = new Hashtable<String, VarSym>();
	}

	public void addVar(String name, VarSym symbol){
		varTable.put(name, symbol);
	}

	public VarSym getVar(String name){
		return varTable.get(name);
	}
}