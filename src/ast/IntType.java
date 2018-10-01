package ast;
import symboltable.*;

public class IntType extends Type{
	public IntType(boolean c, int line, int column){
		constant = c;
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