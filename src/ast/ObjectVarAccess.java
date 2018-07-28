package ast;
import symboltable.*;

public class ObjectVarAccess extends Expression{
	public Expression e;
	public IdChain i;

	public ObjectVarAccess(Expression e, IdChain i){
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