package ast;
import symboltable.*;

public class MethodDef extends Node implements Def{
	public Type r;
	public Identifier i;
	public ArgList a;
	public StatementList s;
	public boolean is_static;
	public boolean is_delegate;

	public MethodDef(Type r, Identifier i, ArgList a, StatementList s, boolean is_static, boolean is_delegate, int line, int column){
		this.r = r;
		this.i = i;
		this.a = a;
		this.s = s;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
		this.is_delegate = is_delegate;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}