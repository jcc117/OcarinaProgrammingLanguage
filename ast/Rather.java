package ast;

public class Rather implements Statement{
	Expression e;
	StatementList s;

	public Rather(Expression e, StatementList s){
		this.e = e;
		this.s = s;
	}
}