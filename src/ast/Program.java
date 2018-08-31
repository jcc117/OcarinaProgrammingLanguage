package ast;
import symboltable.*;

public class Program extends Node{
	public StatementList s;
	public DefList d;
	public VarDeclList v;
	public boolean debug;

	public Program(StatementList s, VarDeclList v, DefList d, boolean debug, int line, int column){
		this.s = s;
		this.d = d;
		this.v = v;
		this.debug = debug;
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