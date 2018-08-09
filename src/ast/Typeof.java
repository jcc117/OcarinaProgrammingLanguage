package ast;

import symboltable.*;

public class Typeof extends Expression{
	public Identifier i;
	public IdChain chain;
	public Type t;

	public Typeof(Identifier i, IdChain chain, Type t, int line, int column){
		this.i = i;
		this.chain = chain;
		this.t = t;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}