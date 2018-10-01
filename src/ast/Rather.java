package ast;
import symboltable.*;

public class Rather extends Node{
	public Expression e;
	public StatementList s;

	public Rather(Expression e, StatementList s, int line, int column){
		this.e = e;
		this.s = s;
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