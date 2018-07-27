package ast;
import symboltable.*;

public class IdentifierType extends Type{
	public Identifier i;
	public IdChain chain;

	public IdentifierType(Identifier i, IdChain  chain){
		this.i = i;
		this.chain = chain;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}