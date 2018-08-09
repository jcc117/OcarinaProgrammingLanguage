package ast;
import symboltable.*;

public class Block extends Statement{
	public StatementList l;

	public Block(StatementList l, int line, int column){
		this.l = l;
		this.breakPoint = false;
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