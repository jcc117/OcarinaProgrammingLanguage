package ast;

public class ObjectVarAccess extends Expression{
	public Expression e;
	public Identifier i;

	public ObjectVarAccess(Expression e, Identifier i){
		this.e = e;
		this.i = i;
	}
}