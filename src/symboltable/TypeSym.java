package symboltable;

public class TypeSym{
	public enum TypeEnum{
		INT, DECIMAL, BOOLEAN, ID, FUNCTION, ARRAY, HASHMAP, VOID
	}

	public TypeEnum type;
	public TypeSym arrayType;
	public TypeSym returnType;
	public TypeSym keyType;
	public TypeSym valueType;

	public TypeSym(TypeEnum type){
		this.type = type;
		this.arrayType = null;
		this.returnType = null;
		this.keyType = null;
		this.valueType = null;
	}

	public TypeSym(TypeEnum type, TypeSym t){
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
	}

	public TypeSym(TypeEnum type, TypeSym keyType, TypeSym valueType){
		this.type = type;
		this.arrayType = null;
		this.returnType = null;
		this.keyType = keyType;
		this.valueType = valueType;
	}
}