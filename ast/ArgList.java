package ast;
import symboltable.*;

import java.util.ArrayList;

public class ArgList{
	public ArrayList<Param> l;

	public ArgList(){
		this.l = new ArrayList<Param>();
	}

	public void add(Param p){
		l.add(p);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}