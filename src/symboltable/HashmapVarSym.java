package symboltable;
import ast.*;

public class HashmapVarSym extends VarSym{
	public VarTypeEnum keyType;
	public VarTypeEnum valueType;
	public Sym keyIdType;
	public Sym valueIdType;


	public HashmapVarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, 
		boolean is_initialized, VarTypeEnum type, boolean is_constant, VarTypeEnum keyType, VarTypeEnum valueType){
		super(name, line, column, is_static, protection, is_initialized, type, is_constant);
		this.keyIdType = null;
		this.valueIdType = null;
		this.keyType = keyType;
		this.valueType = valueType;
	}

	public HashmapVarSym(String name, int line, int column, boolean is_static, ProtectionLevel protection, 
		boolean is_initialized, VarTypeEnum type, boolean is_constant, VarTypeEnum keyType, VarTypeEnum valueType, Sym keyIdType, Sym valueIdType){
		super(name, line, column, is_static, protection, is_initialized, type, is_constant);
		this.keyIdType = keyIdType;
		this.valueIdType = valueIdType;
		this.keyType = keyType;
		this.valueType = valueType;
	}
}