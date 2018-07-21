package ast;
import symboltable.*;

public class IdentifierExpr extends Expression{
	public Identifier i;

	public IdentifierExpr(Identifier i){
		this.i = i;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}