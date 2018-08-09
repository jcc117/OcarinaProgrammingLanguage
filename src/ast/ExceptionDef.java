package ast;

import symboltable.*;

public class ExceptionDef extends Node implements Def{
	public Identifier i;
	public int protection;
	public StringLiteral s;

	public ExceptionDef(Identifier i, StringLiteral s, int protection, int line, int column){
		this.i = i;
		this.s = s;
		this.protection = protection;
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