package ast;
import symboltable.*;

public class VarDecl extends Statement implements Def{
	public Type t;
	public Identifier i;
	public int protection;
	public boolean is_static;

	public VarDecl(Type t, Identifier i, int protection, boolean is_static, int line, int column){
		this.t = t;
		this.i = i;
		breakPoint = false;
		this.protection = protection;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}