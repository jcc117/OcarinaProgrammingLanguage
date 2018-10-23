package ast;
import symboltable.*;

public abstract class Statement extends Node{
	public boolean breakPoint;

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}