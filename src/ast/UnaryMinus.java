package ast;
import symboltable.*;

public class UnaryMinus extends Expression{
	public Expression e;

	public UnaryMinus(Expression e){
		this.e = e;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}