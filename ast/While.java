package ast;

public class While extends Statement{
	public Expression e;
	public StatementList s;

	public While(Expression e, StatementList s){
		this.e = e;
		this.s = s;
		breakPoint = false;
	}
}