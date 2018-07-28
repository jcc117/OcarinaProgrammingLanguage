package ast;
import symboltable.*;

public class Rather {
	public Expression e;
	public StatementList s;

	public Rather(Expression e, StatementList s){
		this.e = e;
		this.s = s;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}