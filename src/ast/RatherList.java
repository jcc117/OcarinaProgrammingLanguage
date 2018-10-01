package ast;
import symboltable.*;

import java.util.*;

public class RatherList{
	public ArrayList<Rather> l;

	public RatherList(){
		this.l = new ArrayList<Rather>(); 
	}

	public void add(Rather r){
		l.add(r);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	/*
	public Sym accept(Visitor v){
		return v.visit(this);
	}*/
}