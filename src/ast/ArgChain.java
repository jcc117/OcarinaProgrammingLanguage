package ast;

import symboltable.*;
import java.util.ArrayList;

public class ArgChain{
	public ArrayList<Param> l;

	public ArgChain(){
		l = new ArrayList<Param>();
	}

	public void add(Param p){
		l.add(p);
	}

	public void add(Param p, int x){
		l.add(x, p);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public ArrayList<Param> accept(Visitor v){
		v.visit(this);
	}
}