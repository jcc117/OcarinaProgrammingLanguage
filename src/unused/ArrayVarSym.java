package symboltable;
import ast.*;

public class ArrayVarSym extends VarSym{
	public Sym idType;
	public VarTypeEnum arrayType;

	public ArrayVarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, 
		boolean is_initialized, VarTypeEnum type, boolean is_constant, VarTypeEnum arrayType){
		super(name, line, column, is_static, protection, is_initialized, type, is_constant);
		this.idType = null;
		this.arrayType = arrayType;
	}

	public ArrayVarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, 
		boolean is_initialized, VarTypeEnum type, boolean is_constant, VarTypeEnum arrayType, Sym id_Type){
		super(name, line, column, is_static, protection, is_initialized, type, is_constant);
		this.idType = id_Type;
		this.arrayType = arrayType;
	}
}