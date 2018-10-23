package ast;
import symboltable.*;

import java.util.*;

public class DefList {
	public ArrayList<Def> l;

	public DefList(){
		l = new ArrayList<Def>();
	}

	public void add(Def d){
		l.add(d);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}