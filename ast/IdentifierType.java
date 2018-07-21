package ast;
import symboltable.*;

public class IdentifierType extends Type{
	public Identifier i;

	public IdentifierType(Identifier i){
		this.i = i;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}