package ast;
import symboltable.*;

public class Unless extends Statement{
	public Expression e;
	public StatementList s;

	public Unless(Expression e, StatementList s, int line, int column){
		this.e = e;
		this.s = s;
		breakPoint = false;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}