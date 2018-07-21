package ast;
import symboltable.*;

import java.util.*;

public class StatementList{
	public ArrayList<Statement> l;

	public StatementList(){
		this.l = new ArrayList<Statement>(); 
	}

	public void add(Statement s){
		l.add(s);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}