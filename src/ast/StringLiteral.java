package ast;
import symboltable.*;

public class StringLiteral extends Expression{
	public String s;

	public StringLiteral(String s, int line, int column){
		this.s = s;
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