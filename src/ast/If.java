package ast;
import symboltable.*;

public class If extends Statement{
	public Expression e;
	public StatementList s1;
	public RatherList r;
	public StatementList s2;

	public If(Expression e, StatementList s1, RatherList r, StatementList s2, int line, int column){
		this.e = e;
		this.s1 = s1;
		this.r = r;
		this.s2 = s2;
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