package ast;
import symboltable.*;

public class StringType extends Type{
	public StringType(boolean c){
		constant = c;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}