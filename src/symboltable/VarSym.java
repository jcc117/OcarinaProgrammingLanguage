package symboltable;
import ast.*;

//Represents a variable symbol
public class VarSym extends Sym{
	public TypeSym type;
	public boolean is_constant;

	//Build a variable
	public VarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, boolean is_initialized, TypeSym type, boolean is_constant, Sym parent, String path){
		this.name = name;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
		this.protection = protection;
		this.is_initialized = is_initialized;
		this.type = type;
		this.is_constant = is_constant;
		this.parent = parent;
		this.path = path;
	}
}