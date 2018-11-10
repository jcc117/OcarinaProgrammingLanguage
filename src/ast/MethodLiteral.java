package ast;
import symboltable.*;

public class MethodLiteral extends Expression{
	public StatementList s;
	public String name;
	public ArgList parameters;

	public MethodLiteral(StatementList s, ArgList parameters, String name, int line, int column){
		this.s = s;
		this.line = line;
		this.column = column;
		this.name = name;
		this.parameters = parameters;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public TypeSym accept(Visitor v){
		return v.visit(this);
	}
}