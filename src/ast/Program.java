package ast;
import symboltable.*;

public class Program extends Node{
	public StatementList s;
	public DefinitionList d;
	public boolean debug;

	public Program(StatementList s, DefinitionList d, boolean debug, int line, int column){
		this.s = s;
		this.d = d;
		this.debug = debug;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}