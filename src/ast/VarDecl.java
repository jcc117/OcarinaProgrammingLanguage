package ast;
import symboltable.*;

public class VarDecl extends Statement implements Def{
	public Type t;
	public Identifier i;
	public int protection;

	public VarDecl(Type t, Identifier i, int protection, int line, int column){
		this.t = t;
		this.i = i;
		breakPoint = false;
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