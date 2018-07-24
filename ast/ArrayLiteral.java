package ast;
import symboltable.*;

public class ArrayLiteral extends Expression{
	public Type t;
	public ParamList l;

	public ArrayLiteral(Type t, ParamList l){
		this.t = t;
		this.l = l;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}