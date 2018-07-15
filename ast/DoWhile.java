package ast;

public class DoWhile implements Statement{
	public Expression e;
	public Statement s;
	public boolean breakPoint;

	public DoWhile(Expression e, Statement s){
		this.e = e;
		this.s = s;
		breakPoint = false;
	}
}