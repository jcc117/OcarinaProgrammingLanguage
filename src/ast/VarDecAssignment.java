package ast;
import symboltable.*;

public class VarDecAssignment extends Statement implements Def{
	public Expression e;
	public Identifier i;
	public Type t;
	public int protection;
	public boolean is_static;

	public VarDecAssignment(Expression e, Identifier i, Type t, int protection, boolean is_static, int line, int column){
		this.e = e;
		this.i = i;
		this.t = t;
		breakPoint = false;
		this.protection = protection;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}