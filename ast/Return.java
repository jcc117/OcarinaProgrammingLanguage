package ast;

public class Return extends Statement{
	public Expression e;

	public Return(Expression e){
		this.e = e;
		breakPoint = false;
	}
}