package ast;
import symboltable.*;

public class StringType extends Type{
	public StringType(boolean c, int line, int column){
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