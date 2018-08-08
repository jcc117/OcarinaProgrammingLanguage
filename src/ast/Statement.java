package ast;
import symboltable.*;

public abstract class Statement extends Node{
	public boolean breakPoint;

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}