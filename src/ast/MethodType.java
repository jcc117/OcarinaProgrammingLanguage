package ast;
import symboltable.*;

public class MethodType extends Type{
	public Type t;

	public MethodType(Type t, boolean c){
		this.t = t;
		constant = c;		
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}