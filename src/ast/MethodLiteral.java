package ast;
import symboltable.*;

public class MethodLiteral extends Expression{
	public ParamList p;
	public StatementList s;

	public MethodLiteral(ParamList p, StatementList s, int line, int column){
		this.p = p;
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