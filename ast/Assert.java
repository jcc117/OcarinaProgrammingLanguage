package ast;

public class Assert extends Statement{
	public Expression e;

	public Assert(Expression e){
		this.e = e;
		breakPoint = false;
	}
}