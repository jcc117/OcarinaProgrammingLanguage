package ast;

public class Exit implements Statement{
	Expression e;

	public Exit(Expression e){
		this.e = e;
	}
}