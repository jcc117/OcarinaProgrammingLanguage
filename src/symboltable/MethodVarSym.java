package symboltable;
import ast.*;

public class MethodVarSym extends VarSym{
	public MethodSym function;	//Function literals will be given a name and stored with other functions, name generated with a $ and UUID

	public MethodVarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, 
		boolean is_initialized, TypeSym type, boolean is_constant, MethodSym function, Sym parent){
		super(name, line, column, is_static, protection, is_initialized, type, is_constant, parent);
		this.function = function;
	}
}