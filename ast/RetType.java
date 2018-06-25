package ast;

public class RetType{
	public enum RetTypeList {INT, FLOAT, BOOLEAN, HASHMAP, ARRAY, STRING, IDENTIFIER, VOID; }

	public String i;
	public RetTypeList t;

	public RetType(RetTypeList t){
		this.t = t;
		this.i = null;
	}

	public RetType(RetTypeList t, String i){
		this.t = t;
		this.i = i;
	}
}