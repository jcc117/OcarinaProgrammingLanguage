package ast;
import symboltable.*;

public class Sage extends Node{
	public Identifier i;
	public VarDeclList v;
	public DefList d;
	public Program p;
	public UsingList u;

	public Sage(Identifier i, DefList d, UsingList u, VarDeclList v, int line, int column){
		this.i = i;
		this.d = d;
		this.p = null;
		this.u = u;
		this.line = line;
		this.column = column;
		this.v = v;
	}

	public Sage(Identifier i, Program p, UsingList u, int line, int column){
		this.i = i;
		this.p = p;
		this.d = null;
		this.u = u;
		this.line = line;
		this.column = column;
		this.v = null;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}