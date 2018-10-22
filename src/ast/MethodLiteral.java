package ast;
import symboltable.*;

public class MethodLiteral extends Expression{
	public ArgList p;
	public StatementList s;
	public String name;
	public Type returnType;

	public MethodLiteral(ArgList p, StatementList s, String name, Type returnType, int line, int column){
		this.p = p;
		this.returnType = returnType;
		this.s = s;
		this.line = line;
		this.column = column;
		this.name = name;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	/*
	public Sym accept(Visitor v){
		return v.visit(this);
	}*/
}