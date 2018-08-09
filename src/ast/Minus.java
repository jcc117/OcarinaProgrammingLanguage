package ast;
import symboltable.*;

public class Minus extends Expression{
	public Expression e1;
	public Expression e2;

	public Minus(Expression e1, Expression e2, int line, int column){
		this.e1 = e1;
		this.e2 = e2;
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