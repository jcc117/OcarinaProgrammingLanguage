package ast;

import symboltable.*;

public class TryCatch extends Statement{
	public StatementList l;
	public CatchList c;
	public StatementList f;

	public TryCatch(StatementList l, CatchList c){
		this.l = l;
		this.c = c;
		this.f = new StatementList();
	}

	public TryCatch(StatementList l, CatchList c, StatementList f){
		this.l = l;
		this.c = c;
		this.f = f;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}