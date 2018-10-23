package ast;
import symboltable.*;

public class Foreach extends Statement{
	public Type t;
	public Identifier i1;
	public Identifier i2;
	public IdChain chain;
	public StatementList s;

	public Foreach(Type t, Identifier i1, Identifier i2, IdChain chain, StatementList s, int line, int column){
		this.t = t;
		this.i1 = i1;
		this.i2 = i2;
		this.chain  = chain;
		this.s = s;
		breakPoint = false;
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