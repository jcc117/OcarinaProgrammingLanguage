package ast;
import symboltable.*;

public class ObjectCreate extends Expression{
	public ParamList l;
	public Identifier i;

	public ObjectCreate(Identifier i, ParamList l){
		this.l = l;
		this.i = i;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}