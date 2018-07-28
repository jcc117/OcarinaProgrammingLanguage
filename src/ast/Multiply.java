package ast;
import symboltable.*;

public class Multiply extends Expression{
	public Expression e1;
	public Expression e2;

	public Multiply(Expression e1, Expression e2){
		this.e1 = e1;
		this.e2 = e2;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}