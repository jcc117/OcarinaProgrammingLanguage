package ast;

public class If implements Statement{
	Expression e;
	Statement s1;
	RatherList r;
	Statement s2;

	public If(Expression e, Statement s1, RatherList r, Statement s2){
		this.e = e;
		this.s1 = s1;
		this.r = r;
		this.s2 = s2;
	}
}