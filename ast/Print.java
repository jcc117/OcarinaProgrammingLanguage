package ast;

public class Print implements Statement{
	public Expression e;
	public boolean breakPoint;

	public Print(Expression e){
		this.e = e;
		breakPoint = false;
	}
}