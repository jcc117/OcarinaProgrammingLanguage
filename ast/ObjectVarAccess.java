package ast;
import symboltable.*;

public class ObjectVarAccess extends Expression{
	public Expression e;
	public Identifier i;

	public ObjectVarAccess(Expression e, Identifier i){
		this.e = e;
		this.i = i;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}