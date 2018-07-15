package ast;

public class Exit extends Statement{
	public Expression e;

	public Exit(Expression e){
		this.e = e;
		breakPoint = false;
	}
}