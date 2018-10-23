package ast;
import symboltable.*;

public class Continue extends Statement{

	public Continue(int line, int column){
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