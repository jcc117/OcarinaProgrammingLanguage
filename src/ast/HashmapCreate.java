package ast;
import symboltable.*;

public class HashmapCreate extends Expression{
	public Type t1;
	public Type t2;

	public HashmapCreate(Type t1, Type t2){
		this.t1 = t1;
		this.t2 = t2;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}