package ast;
import symboltable.*;

public class ArrayAssignment extends Statement{
	public Identifier i;
	public Expression e1;
	public Expression e2;
	public IdChain chain;

	public ArrayAssignment(Identifier i, IdChain chain, Expression e1, Expression e2, int line, int column){
		this.i = i;
		this.e1 = e1;
		this.e2 = e2;
		breakPoint = false;
		this.line = line;
		this.column = column;
		this.chain = chain;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}