package ast;

public class ArrayType extends Type{
	public Type t;

	public ArrayType(Type t){
		this.t = t;		
	}
}