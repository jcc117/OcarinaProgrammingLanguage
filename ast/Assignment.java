package ast;

public class Assignment extends Statement{
	public Expression e;
	public Identifier i;

	public Assignment(Expression e, Identifier i){
		this.e = e;
		this.i = i;
		breakPoint = false;
	}
}