package ast;
import symboltable.*;

import java.util.*;

public class StatementList{
	public ArrayList<Statement> l;

	public StatementList(){
		this.l = new ArrayList<Statement>(); 
	}

	public void add(Statement s){
		l.add(0, s);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}