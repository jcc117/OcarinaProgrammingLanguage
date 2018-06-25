package ast;

public class HashmapCreate extends Expression{
	public Type t1;
	public Type t2;

	public HashmapCreate(Type t1, Type t2){
		this.t1 = t1;
		this.t2 = t2;
	}
}