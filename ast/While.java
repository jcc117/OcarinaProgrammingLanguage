package ast;

public class While implements Statement{
	public Expression e;
	public Statement s;
	public boolean breakPoint;

	public While(Expression e, Statement s){
		this.e = e;
		this.s = s;
		breakPoint = false;
	}
}