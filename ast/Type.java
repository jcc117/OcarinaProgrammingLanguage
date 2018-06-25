package ast;

public class Type{
	public enum TypeList {INT, FLOAT, BOOLEAN, HASHMAP, ARRAY, STRING, IDENTIFIER; }

	public String i;
	public TypeList t;

	public Type(TypeList t){
		this.t = t;
		this.i = null;
	}

	public Type(TypeList t, String i){
		this.t = t;
		this.i = i;
	}
}