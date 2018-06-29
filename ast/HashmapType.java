package ast;

public class HashmapType extends Type{
	public Type t1;
	public Type t2;
	
	public HashmapType(Type t1, Type t2){
		this.t1 = t1;
		this.t2 = t2;
	}
}