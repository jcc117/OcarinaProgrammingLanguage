package ast;
import symboltable.*;

public class PreIncrement extends Expression{
	public Identifier i;
	public IdChain chain;
	public This t;

	public PreIncrement(Identifier i, IdChain chain, int line, int column){
		this.i = i;
		this.chain = chain;
		this.t = null;
		this.line = line;
		this.column = column;

	}

	public PreIncrement(This t, IdChain chain, int line, int column){
		this.t = t;
		this.chain = chain;
		this.i  = null;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public TypeSym accept(Visitor v){
		return v.visit(this);
	}
}