package ast;

public class VarDecAssignment extends Statement{
	public Expression e;
	public Identifier i;
	public Type t;
	public int protection;

	public VarDecAssignment(Expression e, Identifier i, Type t, int protection){
		this.e = e;
		this.i = i;
		this.t = t;
		breakPoint = false;
		this.protection = protection;
	}
}