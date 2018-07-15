package ast;

public class While implements Statement{
	public Expression e;
	public StatementList s;
	public boolean breakPoint;

	public While(Expression e, StatementList s){
		this.e = e;
		this.s = s;
		breakPoint = false;
	}
}