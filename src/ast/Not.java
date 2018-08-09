package ast;
import symboltable.*;

public class Not extends Expression{
	public Expression e;

	public Not(Expression e, int line, int column){
		this.e = e;
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