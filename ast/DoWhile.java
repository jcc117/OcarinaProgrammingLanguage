package ast;

public class DoWhile implements Statement{
	public Expression e;
	public StatementList s;
	public boolean breakPoint;

	public DoWhile(Expression e, StatementList s){
		this.e = e;
		this.s = s;
		breakPoint = false;
	}
}