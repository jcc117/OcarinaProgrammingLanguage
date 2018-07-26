package ast;
import symboltable.*;

public class Super extends Statement{

	public Super(){
		breakPoint = false;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}