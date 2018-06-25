package ast;

public class If implements Statement{
	Expression e;
	StatementList s1;
	StatementList s2;

	public If(Expression e, StatementList s1, StatementList s2){
		this.e = e;
		this.s1 = s1;
		this.s2 = s2;
	}
}