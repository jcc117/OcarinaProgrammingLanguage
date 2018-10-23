package ast;
import symboltable.*;

public class Break extends Statement{

	public Break(int line, int column){
		breakPoint = false;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}