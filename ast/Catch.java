package ast;

import symboltable.*;

public class Catch{
	public StatementList s;
	public IdChain chain;
	public Identifier i;
	public Identifier i2;

	public Catch(Identifier i, IdChain chain, Identifier i2, StatementList s){
		this.i = i;
		this.chain = chain;
		this.i2 = i2;
		this.s = s;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}