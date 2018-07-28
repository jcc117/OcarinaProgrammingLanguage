package ast;
import symboltable.*;

public class Block extends Statement{
	public StatementList l;

	public Block(StatementList l){
		this.l = l;
		this.breakPoint = false;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}