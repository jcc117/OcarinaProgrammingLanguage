package ast;
import symboltable.*;

public class MethodLiteral extends Expression{
	public StatementList s;
	public String name;

	public MethodLiteral(StatementList s, String name, Type returnType, int line, int column){
		this.s = s;
		this.line = line;
		this.column = column;
		this.name = name;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public TypeSym accept(Visitor v){
		return v.visit(this);
	}
}