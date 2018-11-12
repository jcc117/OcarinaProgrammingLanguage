package ast;

import symboltable.*;

public class Typeof extends Expression{
	public Expression e;
	public Type t;

	public Typeof(Expression e, Type t, int line, int column){
		this.e = e;
		this.t = t;
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