package ast;
import symboltable.*;

public class Not extends Expression{
	public Expression e;

	public Not(Expression e){
		this.e = e;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}