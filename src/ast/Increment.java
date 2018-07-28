package ast;
import symboltable.*;

public class Increment extends Statement{
	public Identifier i;
	public IdChain chain;
	public This t;

	public Increment(Identifier i, IdChain chain){
		this.i = i;
		this.chain = chain;
		this.t = null;
		breakPoint = false;
	}

	public Increment(This t, IdChain chain){
		this.t = t;
		this.chain = chain;
		this.i  = null;
		breakPoint = false;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}