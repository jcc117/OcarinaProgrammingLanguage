package ast;
import symboltable.*;

public class Until extends Statement{
	public Expression e;
	public StatementList s;

	public Until(Expression e, StatementList s){
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