package ast;
import symboltable.*;

public class GetBoolean extends Expression{
	public GetBoolean(){
		
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}