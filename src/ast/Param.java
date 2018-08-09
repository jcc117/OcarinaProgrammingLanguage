package ast;
import symboltable.*;

public class Param extends Node{
	public Type t;
	public Identifier i;

	public Param(Type t, Identifier i, int line, int column){
		this.t = t;
		this.i = i;
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