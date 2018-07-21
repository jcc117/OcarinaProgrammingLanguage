package ast;
import symboltable.*;

public class Using{
	public Identifier i;

	public Using(Identifier i){
		this.i = i;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}