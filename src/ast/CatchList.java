package ast;

import symboltable.*;
import java.util.ArrayList;
public class CatchList{
	public ArrayList<Catch> l;

	public CatchList(){
		l = new ArrayList<Catch>();
	}

	public void add(Catch c, int x){
		l.add(x, c);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}