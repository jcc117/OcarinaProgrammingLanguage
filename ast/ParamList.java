package ast;

import java.util.ArrayList;

public class ParamList extends Expression{
	public ArrayList<Expression> l;

	public ParamList(ArrayList<Expression> l){
		this.l = l;
	}
}