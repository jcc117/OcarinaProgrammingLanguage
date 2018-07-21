package ast;
import symboltable.*;

public class ArrayType extends Type{
	public Type t;

	public ArrayType(Type t){
		this.t = t;		
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}