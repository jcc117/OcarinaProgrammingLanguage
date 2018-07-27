package ast;
import symboltable.*;

public class VoidType extends Type{
	public VoidType(){
		constant = false;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}