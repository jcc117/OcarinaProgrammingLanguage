package ast;
import symboltable.*;

public class PostIncrement extends Expression{
	public Identifier i;
	public IdChain chain;
	public This t;

	public PostIncrement(Identifier i, IdChain chain, int line, int column){
		this.i = i;
		this.chain = chain;
		this.t = null;
		this.line = line;
		this.column = column;

	}

	public PostIncrement(This t, IdChain chain, int line, int column){
		this.t = t;
		this.chain = chain;
		this.i  = null;
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