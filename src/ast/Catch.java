package ast;

import symboltable.*;

public class Catch extends Node{
	public StatementList s;
	public IdChain chain;
	public Identifier i;
	public Identifier i2;

	public Catch(Identifier i, IdChain chain, Identifier i2, StatementList s, int line, int column){
		this.i = i;
		this.chain = chain;
		this.i2 = i2;
		this.s = s;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}