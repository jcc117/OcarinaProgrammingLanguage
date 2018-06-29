package ast;

public class IdentifierExpr extends Expression{
	public Identifier i;

	public IdentifierExpr(Identifier i){
		this.i = i;
	}
}