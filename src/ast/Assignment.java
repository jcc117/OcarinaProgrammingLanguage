package ast;
import symboltable.*;

public class Assignment extends Statement{
	public Expression e;
	public Identifier i;

	public Assignment(Expression e, Identifier i){
		this.e = e;
		this.i = i;
		breakPoint = false;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}