package symboltable;
import ast.*;

public class IdVarSym extends VarSym{
	public Sym id_Type;

	public IdVarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, 
		boolean is_initialized, VarTypeEnum type, boolean is_constant, Sym id_Type){
		super(name, line, column, is_static, protection, is_initialized, type, is_constant);
		this.id_Type = id_Type;
	}
}