package ast;
import symboltable.*;

public class SimpleClassDef extends Node implements ClassDef{
	public Identifier i;
	public DefinitionList d;
	public boolean is_static;

	public SimpleClassDef(Identifier i, DefinitionList d, boolean singleton, int line, int column){
		this.i = i;
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