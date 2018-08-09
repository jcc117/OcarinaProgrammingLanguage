package ast;
import symboltable.*;

public class Throw extends Statement{
	public Identifier i;
	public IdChain chain;
	public This t;

	public Throw(Identifier i, IdChain chain, int line, int column){
		this.i = i;
		this.chain = chain;
		this.t = null;
		breakPoint = false;
		this.line = line;
		this.column = column;
	}

	public Throw(This t, IdChain chain, int line, int column){
		this.i = null;
		this.chain = chain;
		this.t = t;
		breakPoint = false;
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