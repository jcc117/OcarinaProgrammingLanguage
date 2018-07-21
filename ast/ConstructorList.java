package ast;
import symboltable.*;

import java.util.*;

public class ConstructorList{
	public ArrayList<Constructor> l;

	public ConstructorList(){
		this.l = new ArrayList<Constructor>(); 
	}

	public void add(Constructor s){
		l.add(s);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}