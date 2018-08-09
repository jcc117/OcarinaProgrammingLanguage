package ast;
import symboltable.*;

public class Using extends Node{
	public Identifier i;
	public IdChain chain;

	public Using(Identifier i, IdChain chain, int line, int column){
		this.i = i;
		this.chain = chain;
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