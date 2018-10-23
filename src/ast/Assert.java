package ast;
import symboltable.*;

public class Assert extends Statement{
	public Expression e;

	public Assert(Expression e, int line, int column){
		this.e = e;
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