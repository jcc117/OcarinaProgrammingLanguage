package ast;
import symboltable.*;

public abstract class Type extends Node{
	public boolean constant;
	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public TypeSym accept(Visitor v){
		return v.visit(this);
	}
}