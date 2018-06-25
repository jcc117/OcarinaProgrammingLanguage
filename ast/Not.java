package ast;

public class Not extends Expression{
	public Expression e;

	public Not(Expression e){
		this.e = e;
	}
}