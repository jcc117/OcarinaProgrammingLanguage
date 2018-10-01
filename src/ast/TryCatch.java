package ast;

import symboltable.*;

public class TryCatch extends Statement{
	public StatementList l;
	public CatchList c;
	public StatementList f;

	public TryCatch(StatementList l, CatchList c, int line, int column){
		this.l = l;
		this.c = c;
		this.f = new StatementList();
		this.line = line;
		this.column = column;
	}

	public TryCatch(StatementList l, CatchList c, StatementList f, int line, int column){
		this.l = l;
		this.c = c;
		this.f = f;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	/*
	public Sym accept(Visitor v){
		return v.visit(this);
	}*/
}