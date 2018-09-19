package ast;
import symboltable.*;

public class Throw extends Statement{
	public Expression e;

	public Throw(Expression e, int line, int column){
		this.e = e;
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