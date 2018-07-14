package ast;

public class Exit implements Statement{
	public Expression e;
	public boolean breakPoint;

	public Exit(Expression e){
		this.e = e;
		breakPoint = false;
	}
}