package ast;

public class ArrayExpr extends Expression{
	public Expression e1;
	public Expression e2;

	public ArrayExpr(Expression e1, Expression e2){
		this.e1 = e1;
		this.e2 = e2;
	}
}