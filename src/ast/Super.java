package ast;
import symboltable.*;

public class Super extends Statement{

	public ParamList p;

	public Super(ParamList p, int line, int column){
		breakPoint = false;
		this.p = p;
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