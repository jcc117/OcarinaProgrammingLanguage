package ast;

public class HashmapAssignment extends Statement{
	public Identifier i;
	public Expression e1;
	public Expression e2;

	public HashmapAssignment(Identifier i, Expression e1, Expression e2){
		this.i = i;
		this.e1 = e1;
		this.e2 = e2;
		breakPoint = false;
	}
}