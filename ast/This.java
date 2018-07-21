package ast;
import symboltable.*;

public class This extends Expression{
	public This(){
		
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}