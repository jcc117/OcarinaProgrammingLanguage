package ast;

public class While implements Statement{
	public Expression e;
	public StatementList s;

	public While(Expression e, StatementList s){
		this.e = e;
		this.s = s;
	}
}