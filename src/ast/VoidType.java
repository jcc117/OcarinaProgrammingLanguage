package ast;
import symboltable.*;

public class VoidType extends Type{
	public VoidType(int line, int column){
		constant = false;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public TypeSym accept(Visitor v){
		return v.visit(this);
	}
}