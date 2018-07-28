package ast;

import symboltable.*;

public class ExceptionDef implements Def{
	public Identifier i;
	public int protection;
	public StringLiteral s;

	public ExceptionDef(Identifier i, StringLiteral s, int protection){
		this.i = i;
		this.s = s;
		this.protection = protection;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}