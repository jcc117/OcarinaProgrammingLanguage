package ast;
import symboltable.*;

public class SimpleClassDef extends Node implements ClassDef{
	public Identifier i;
	public DefList d;
	public int protection;
	public boolean singleton;

	public SimpleClassDef(Identifier i, DefList d, int protection, boolean singleton, int line, int column){
		this.i = i;
		this.d = d;
		this.protection = protection;
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