package ast;

public class ParentExpr extends Expression{
	public Expression e;

	public ParentExpr(Expression e){
		this.e = e;
	}
}