package ast;

public class DoWhile extends Statement{
	public Expression e;
	public StatementList s;

	public DoWhile(Expression e, StatementList s){
		this.e = e;
		this.s = s;
		breakPoint = false;
	}
}