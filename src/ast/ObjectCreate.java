package ast;
import symboltable.*;

public class ObjectCreate extends Expression{
	public ParamList l;
	public Identifier i;
	public IdChain chain;

	public ObjectCreate(Identifier i, IdChain chain, ParamList l, int line, int column){
		this.l = l;
		this.i = i;
		this.chain = chain;
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