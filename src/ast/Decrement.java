package ast;
import symboltable.*;

public class Decrement extends Statement{
	public Identifier i;
	public IdChain chain;
	public This t;

	public Decrement(Identifier i, IdChain chain){
		this.i = i;
		this.chain = chain;
		this.t = null;
		breakPoint = false;
	}

	public Decrement(This t, IdChain chain){
		this.i = null;
		this.chain = chain;
		this.t = t;
		breakPoint = false;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}