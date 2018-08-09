package ast;
import symboltable.*;

public class Identifier extends Expression{
	public String i;

	public Identifier(String i, int line, int column){
		this.i = i;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}