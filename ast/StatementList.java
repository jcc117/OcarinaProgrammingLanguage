package ast;

import java.util.*;

public class StatementList{
	public ArrayList<Statement> l;

	public StatementList(){
		this.l = new ArrayList<Statement>(); 
	}

	public void add(Statement s){
		l.add(s);
	}
}