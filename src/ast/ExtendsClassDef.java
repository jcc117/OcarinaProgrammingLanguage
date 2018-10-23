package ast;
import symboltable.*;

public class ExtendsClassDef extends Node implements ClassDef{
	public Identifier i;
	public Identifier c;
	public DefList d;
	public int protection;
	public boolean is_static;

	public ExtendsClassDef(Identifier i, Identifier c, DefList d, int protection, boolean singleton, int line, int column){
		this.i = i;
		this.c = c;
		this.d = d;
		this.protection = protection;
		this.is_static = singleton;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}