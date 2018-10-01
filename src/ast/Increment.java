package ast;
import symboltable.*;

public class Increment extends Statement{
	public Identifier i;
	public IdChain chain;
	public This t;

	public Increment(Identifier i, IdChain chain, int line, int column){
		this.i = i;
		this.chain = chain;
		this.t = null;
		breakPoint = false;
		this.line = line;
		this.column = column;

	}

	public Increment(This t, IdChain chain, int line, int column){
		this.t = t;
		this.chain = chain;
		this.i  = null;
		breakPoint = false;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	/*
	public Sym accept(Visitor v){
		return v.visit(this);
	}*/
}