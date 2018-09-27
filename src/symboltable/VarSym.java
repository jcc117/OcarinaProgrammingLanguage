package symboltable;
import ast.*;

public class VarSym extends Sym{
	public enum VarTypeEnum{
		INT, DECIMAL, BOOLEAN, STRING, ARRAY, HASHMAP, ID, FUNCTION, VOID;	//VOID may only be used for MethodVarSym returnType
	}
	public VarTypeEnum type;
	public boolean is_constant;

	public VarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, boolean is_initialized, VarTypeEnum type, boolean is_constant){
		this.name = name;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
		this.protection = protection;
		this.is_initialized = is_initialized;
		this.type = type;
		this.is_constant = is_constant;
	}
}