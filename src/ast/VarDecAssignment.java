package ast;
import symboltable.*;

public class VarDecAssignment extends Statement implements Def{
	public Expression e;
	public Identifier i;
	public Type t;
	public boolean is_static;

	public VarDecAssignment(Expression e, Identifier i, Type t, boolean is_static, int line, int column){
		this.e = e;
		this.i = i;
		this.t = t;
		breakPoint = false;
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