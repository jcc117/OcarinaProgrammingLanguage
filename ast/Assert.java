package ast;

public class Assert implements Statement{
	Expression e;

	public Assert(Expression e){
		this.e = e;
	}
}