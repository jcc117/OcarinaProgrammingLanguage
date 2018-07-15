package ast;

public class If implements Statement{
	public Expression e;
	public StatementList s1;
	public RatherList r;
	public StatementList s2;
	public boolean breakPoint;

	public If(Expression e, StatementList s1, RatherList r, StatementList s2){
		this.e = e;
		this.s1 = s1;
		this.r = r;
		this.s2 = s2;
		breakPoint = false;
	}
}