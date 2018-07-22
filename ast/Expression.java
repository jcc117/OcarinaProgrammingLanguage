package ast;
import symboltable.*;

public abstract class Expression extends Node{
	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}