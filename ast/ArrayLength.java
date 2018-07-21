package ast;
import symboltable.*;

public class ArrayLength extends Expression{
	public Expression e;
	
	public ArrayLength(Expression e){
		this.e = e;
	}
	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}