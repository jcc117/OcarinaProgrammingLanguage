package ast;
import symboltable.*;

public class Param {
	public Type t;
	public Identifier i;

	public Param(Type t, Identifier i){
		this.t = t;
		this.i = i;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}