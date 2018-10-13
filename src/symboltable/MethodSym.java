package symboltable;
import ast.*;
import java.util.Hashtable;

public class MethodSym extends Sym{

	public Hashtable<String, VarSym> varTable;
	public Hashtable<String, MethodScope> innerScopeTable;
	public Hashtable<String, MethodSym> methodLiteralTable;
	public TypeSym returnType;
	public boolean is_literal;
	//names for methods will be their signature
	//formatted as "name(type1, type2,...)"

	public MethodSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, TypeSym returnType, boolean is_literal, Sym parent, String path){
		this.name = name;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
		this.protection = protection;
		this.returnType = returnType;
		this.path = path;
		this.varTable = new Hashtable<String, VarSym>();
		this.innerScopeTable = new Hashtable<String, MethodScope>();
		this.methodLiteralTable = new Hashtable<String, MethodSym>();
		this.is_literal = is_literal;
		this.parent = parent;
	}

	public void addVar(String name, VarSym symbol){
		varTable.put(name, symbol);
	}

	public VarSym getVar(String name){
		return varTable.get(name);
	}

	public void addMethodLiteral(String name, MethodSym symbol){
		methodLiteralTable.put(name, symbol);
	}

	public MethodSym getMethodLiteral(String name){
		return methodLiteralTable.get(name);
	}

	/*
	Paths are created as such:
	"2for-1while-4if" represents a for loop with scope equal to the second for loop in the method,
	this first while loop within that for loop, and the 4th if statement in the while loop.
	They are created with a number along with 'for', 'if', 'rather', 'else', 'while', 'do', 'unless',
	'until', 'try', or 'foreach'. Each inner scope is connected with '-'.
	*/
	public void addScope(String path, MethodScope scope){
		innerScopeTable.put(path, scope);
	}

	public MethodScope getScope(String path){
		return innerScopeTable.get(path);
	}
}