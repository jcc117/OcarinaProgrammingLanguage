package ast;

public class VarDecAssignment implements Statement{
	public Expression e;
	public Identifier i;
	public Type t;
	public boolean breakPoint;
	public int protection;

	public VarDecAssignment(Expression e, Identifier i, Type t, int protection){
		this.e = e;
		this.i = i;
		this.t = t;
		breakPoint = false;
		this.protection = protection;
	}
}