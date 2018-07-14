package ast;

public class Assert implements Statement{
	public Expression e;
	public boolean breakPoint;

	public Assert(Expression e){
		this.e = e;
		breakPoint = false;
	}
}