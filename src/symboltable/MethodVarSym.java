package symboltable;
import ast.*;

public class MethodVarSym extends VarSym{
	public VarTypeEnum returnType;
	public MethodSym function;	//Function literals will be given a name and stored with other functions, name generated with a UUID

	public MethodVarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, 
		boolean is_initialized, VarTypeEnum type, boolean is_constant, VarTypeEnum returnType, MethodSym function){
		super(name, line, column, is_static, protection, is_initialized, type, is_constant);
		this.returnType = returnType;
		this.function = function;
	}
}