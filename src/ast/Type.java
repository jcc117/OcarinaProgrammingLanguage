package ast;
import symboltable.*;

public abstract class Type{
	public boolean constant;
	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}