package symboltable;
import ast.*;

public class MethodVarSym extends VarSym{
	public VarTypeEnum returnType;
	//Hmmmm... this will need reworked for function literals
	public MethodVarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, 
		boolean is_initialized, VarTypeEnum type, boolean is_constant, VarTypeEnum returnType){
		super(name, line, column, is_static, protection, is_initialized, type, is_constant);
		this.returnType = returnType;
	}
}