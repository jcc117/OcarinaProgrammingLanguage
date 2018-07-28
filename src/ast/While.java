package ast;
import symboltable.*;

public class While extends Statement{
	public Expression e;
	public StatementList s;

	public While(Expression e, StatementList s){
		this.e = e;
		this.s = s;
		breakPoint = false;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}