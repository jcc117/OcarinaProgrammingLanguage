package ast;
import symboltable.*;

public class Identifier extends Expression{
	public String i;

	public Identifier(String i){
		this.i = i;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}