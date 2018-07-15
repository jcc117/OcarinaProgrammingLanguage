package ast;

public class Print extends Statement{
	public Expression e;

	public Print(Expression e){
		this.e = e;
		breakPoint = false;
	}
}