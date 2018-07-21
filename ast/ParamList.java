package ast;
import symboltable.*;

import java.util.ArrayList;

public class ParamList extends Expression{
	public ArrayList<Expression> l;

	public ParamList(){
		this.l = new ArrayList<Expression>();
	}

	public void add(Expression e){
		l.add(e);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}