package ast;
import symboltable.*;

public class GetBoolean extends Expression{
	public GetBoolean(int line, int column){
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