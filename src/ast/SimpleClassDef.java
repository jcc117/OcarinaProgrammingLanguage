package ast;
import symboltable.*;

public class SimpleClassDef extends Node implements ClassDef{
	public Identifier i;
	public DefList d;
	public VarDeclList v;
	public int protection;
	public ConstructorList c;
	public boolean singleton;

	public SimpleClassDef(Identifier i, DefList d, VarDeclList v, int protection, ConstructorList c, boolean singleton, int line, int column){
		this.i = i;
		this.d = d;
		this.v = v;
		this.protection = protection;
		this.c = c;
		this.singleton = singleton;
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