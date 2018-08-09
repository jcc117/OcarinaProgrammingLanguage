package ast;
import symboltable.*;

public class ExtendsClassDef extends Node implements ClassDef{
	public Identifier i;
	public Identifier c;
	public DefList d;
	public VarDeclList v;
	public int protection;
	public ConstructorList o;
	public boolean singleton;

	public ExtendsClassDef(Identifier i, Identifier c, DefList d, VarDeclList v, int protection, ConstructorList o, boolean singleton, int line, int column){
		this.i = i;
		this.c = c;
		this.d = d;
		this.v = v;
		this.protection = protection;
		this.o = o;
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