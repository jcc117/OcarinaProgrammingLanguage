package ast;
import symboltable.*;

public class ExtendsClassDef extends Node implements ClassDef{
	public Identifier i;
	public Identifier c;
	public DefinitionList d;
	public boolean is_static;

	public ExtendsClassDef(Identifier i, Identifier c, DefinitionList d, boolean singleton, int line, int column){
		this.i = i;
		this.c = c;
		this.d = d;
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