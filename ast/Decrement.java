package ast;
import symboltable.*;

public class Decrement extends Statement{
	public Identifier i;

	public Decrement(Identifier i){
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