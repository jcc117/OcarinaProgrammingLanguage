package ast;

public class Assignment implements Statement{
	public Expression e;
	public Identifier i;
	public boolean breakPoint;

	public Assignment(Expression e, Identifier i){
		this.e = e;
		this.i = i;
		breakPoint = false;
	}
}