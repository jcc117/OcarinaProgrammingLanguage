package ast;
import symboltable.*;

public class StringLiteral extends Expression{
	public String s;

	public StringLiteral(String s){
		this.s = s;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}