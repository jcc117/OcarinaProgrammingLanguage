package ast;
import symboltable.*;

public class Constructor{
	public StatementList l;
	public ArgList a;

	public Constructor(ArgList a, StatementList l){
		this.l = l;
		this.a = a;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}