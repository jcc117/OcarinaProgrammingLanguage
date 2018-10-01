package ast;
import symboltable.*;

public class UnaryMinus extends Expression{
	public Expression e;

	public UnaryMinus(Expression e, int line, int column){
		this.e = e;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	/*
	public Sym accept(Visitor v){
		return v.visit(this);
	}*/
}