package ast;
import symboltable.*;

public abstract class Statement{
	public boolean breakPoint;

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		v.visit(this);
	}
}