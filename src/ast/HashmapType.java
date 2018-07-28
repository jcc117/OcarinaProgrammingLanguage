package ast;
import symboltable.*;

public class HashmapType extends Type{
	public Type t1;
	public Type t2;
	
	public HashmapType(Type t1, Type t2, boolean c){
		this.t1 = t1;
		this.t2 = t2;
		constant = c;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}