package ast;
import symboltable.*;

public class ObjectVarAccess extends Expression{
	public Expression e;
	public Identifier i;

	public ObjectVarAccess(Expression e, Identifier i, int line, int column){
		this.e = e;
		this.line = line;
		this.column = column;
		this.i = i;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public TypeSym accept(Visitor v){
		return v.visit(this);
	}
}