package ast;
import symboltable.*;

import java.util.ArrayList;

public class ParamList extends Expression{
	public Expression e;
	public ExprChain chain;

	public ParamList(Expression e, ExprChain chain){
		this.e = e;
		this.chain = chain;
	}

	public ParamList(){
		this.e = null;
		this.chain = null;
	}
	
	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public TypeSym accept(Visitor v){
		return v.visit(this);
	}
}