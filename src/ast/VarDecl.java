package ast;
import symboltable.*;

public class VarDecl extends Statement{
	public Type t;
	public Identifier i;
	public int protection;

	public VarDecl(Type t, Identifier i, int protection){
		this.t = t;
		this.i = i;
		breakPoint = false;
		this.protection = protection;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}