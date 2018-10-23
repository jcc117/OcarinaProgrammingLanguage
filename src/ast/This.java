package ast;
import symboltable.*;

public class This extends Expression{
	public This(int line, int column){
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