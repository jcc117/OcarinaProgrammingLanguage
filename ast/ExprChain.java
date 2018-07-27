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

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}