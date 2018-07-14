package ast;

public class Rather implements Statement{
	Expression e;
	Statement s;

	public Rather(Expression e, Statement s){
		this.e = e;
		this.s = s;
	}
}