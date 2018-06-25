package ast;

public class Print implements Statement{
	public Expression e;

	public Print(Expression e){
		this.e = e;
	}
}