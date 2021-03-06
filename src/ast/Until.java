package ast;
import symboltable.*;

public class Until extends Statement{
	public Expression e;
	public StatementList s;

	public Until(Expression e, StatementList s, int line, int column){
		this.e = e;
		this.s = s;
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