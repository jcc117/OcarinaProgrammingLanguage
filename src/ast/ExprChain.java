package ast;

import symboltable.*;
import java.util.ArrayList;

public class ExprChain{
	public ArrayList<Expression> l;

	public ExprChain(){
		l = new ArrayList<Expression>();
	}

	public void add(Expression p){
		l.add(p);
	}

	public void add(Expression e, int x){
		l.add(x, e);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}