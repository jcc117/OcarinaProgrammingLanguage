package ast;
import symboltable.*;

public class GetString extends Expression{
	public GetString(int line, int column){
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