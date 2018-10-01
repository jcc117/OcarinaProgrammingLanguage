package ast;
import symboltable.*;

public class ArrayType extends Type{
	public Type t;
	public boolean constant;

	public ArrayType(Type t, boolean c, int line, int column){
		this.t = t;
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