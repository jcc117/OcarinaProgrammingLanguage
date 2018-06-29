package ast;

import java.util.ArrayList;

public class ParamList extends Expression{
	public ArrayList<Expression> l;

	public ParamList(){
		this.l = new ArrayList<Expression>();
	}

	public void add(Expression e){
		l.add(e);
	}
}