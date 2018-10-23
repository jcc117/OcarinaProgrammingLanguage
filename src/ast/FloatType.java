package ast;
import symboltable.*;

public class FloatType extends Type{
	public FloatType(boolean c, int line, int column){
		constant = c;
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