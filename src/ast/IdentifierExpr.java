package ast;
import symboltable.*;

public class IdentifierExpr extends Expression{
	public Identifier i;

	public IdentifierExpr(Identifier i, int line, int column){
		this.i = i;
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