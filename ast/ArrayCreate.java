package ast;
import symboltable.*;

public class ArrayCreate extends Expression{
	Type t;
	Expression e;

	public ArrayCreate(Type t, Expression e){
		this.t = t;
		this.e = e;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}