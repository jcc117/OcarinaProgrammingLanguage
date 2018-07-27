package ast;

import symboltable.*;

public class Typeof extends Expression{
	public Identifier i;
	public IdChain chain;
	public Type t;

	public Typeof(Identifier i, IdChain chain, Type t){
		this.i = i;
		this.chain = chain;
		this.t = t;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}