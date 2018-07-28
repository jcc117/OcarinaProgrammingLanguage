package ast;
import symboltable.*;

public class Sage{
	public Identifier i;
	public DefList d;
	public Program p;
	public UsingList u;

	public Sage(Identifier i, DefList d, UsingList u){
		this.i = i;
		this.d = d;
		this.p = null;
		this.u = u;
	}

	public Sage(Identifier i, Program p, UsingList u){
		this.i = i;
		this.p = p;
		this.d = null;
		this.u = u;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}