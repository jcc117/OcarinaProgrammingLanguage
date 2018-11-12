package ast;
import symboltable.*;

public class PreDecrement extends Expression{
	public Expression e;

	public PreDecrement(Expression e, int line, int column){
		this.e = e;
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