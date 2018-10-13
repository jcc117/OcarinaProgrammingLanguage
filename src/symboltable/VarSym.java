package symboltable;
import ast.*;

public class VarSym extends Sym{
	public TypeSym type;
	public boolean is_constant;

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