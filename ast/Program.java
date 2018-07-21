package ast;
import symboltable.*;

public class Program{
	public StatementList s;
	public DefList d;
	public boolean debug;

	public Program(StatementList s, DefList d, boolean debug){
		this.s = s;
		this.d = d;
		this.debug = debug;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}