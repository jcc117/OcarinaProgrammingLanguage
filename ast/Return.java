package ast;

public class Return implements Statement{
	Expression e;

	public Return(Expression e){
		this.e = e;
	}
}