package ast;
import symboltable.*;

public class ObjectVarAccess extends Expression{
	public Expression e;
	public IdChain i;

	public ObjectVarAccess(Expression e, IdChain i, int line, int column){
		this.e = e;
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