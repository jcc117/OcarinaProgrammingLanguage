package symboltable;

public class TypeSym{
	public enum TypeEnum{
		INT, DECIMAL, BOOLEAN, ID, STRING, FUNCTION, ARRAY, HASHMAP, VOID, VAR
	}

	public TypeEnum type;
	public TypeSym arrayType;
	public TypeSym returnType;
	public TypeSym keyType;
	public TypeSym valueType;
	public Sym idSym;
	public boolean is_constant;

	public TypeSym(TypeEnum type, boolean is_constant){
		this.type = type;
		this.arrayType = null;
		this.returnType = null;
		this.keyType = null;
		this.valueType = null;
		this.idSym = null;
		this.is_constant = is_constant;
	}

	public TypeSym(TypeEnum type, Sym idSym, boolean is_constant){
		this.type = type;
		this.arrayType = null;
		this.returnType = null;
		this.keyType = null;
		this.valueType = null;
		this.idSym = idSym;
		this.is_constant = is_constant;
	}

	public TypeSym(TypeEnum type, TypeSym t, boolean is_constant){
		this.type = type;
		if(type == TypeEnum.FUNCTION){
			this.returnType = t;
			this.arrayType = null;
		}
		else{
			this.arrayType = t;
			this.returnType = null;
		}

		this.keyType = null;
		this.valueType = null;
		this.idSym = null;
		this.is_constant = is_constant;
	}

	public TypeSym(TypeEnum type, TypeSym keyType, TypeSym valueType, boolean is_constant){
		this.type = type;
		this.arrayType = null;
		this.returnType = null;
		this.keyType = keyType;
		this.valueType = valueType;
		this.idSym = null;
		this.is_constant = is_constant;
	}

	public String toString(){
		switch(type){
			case INT:	return "int";
			case DECIMAL:	return "decimal";
			case BOOLEAN:	return "boolean";
			case ID:	return idSym.name;
			case STRING:	return "string";
			case FUNCTION:	return "function{" + returnType.toString() + "}";
			case ARRAY:	return arrayType.toString() + "[]";
			case HASHMAP:	return "hashmap{" + keyType.toString() + "," + valueType.toString() + "}";
			case VOID:	return "void";
			case VAR:	return "var";
			default: return "";
		}
	}
}