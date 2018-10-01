package ast;
import symboltable.*;

public class MethodDef extends Node implements Def{
	public Type r;
	public Identifier i;
	public ArgList a;
	public StatementList s;
	public int protection;
	public boolean is_static;

	public MethodDef(Type r, Identifier i, ArgList a, StatementList s, int protection, boolean is_static,int line, int column){
		this.r = r;
		this.i = i;
		this.a = a;
		this.s = s;
		this.protection = protection;
		this.line = line;
		this.column = column;
		this.is_static = is_static;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	/*
	public Sym accept(Visitor v){
		return v.visit(this);
	}*/
}