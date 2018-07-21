package ast;
import symboltable.*;

public class StringType extends Type{
	public StringType(){
		
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}