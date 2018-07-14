package ast;

public class Return implements Statement{
	public Expression e;
	public boolean breakPoint;

	public Return(Expression e){
		this.e = e;
		breakPoint = false;
	}
}