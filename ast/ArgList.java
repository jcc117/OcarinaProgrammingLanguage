package ast;

import java.util.ArrayList;

public class ArgList{
	public ArrayList<Param> l;

	public ArgList(){
		this.l = new ArrayList<Param>();
	}

	public void add(Param p){
		l.add(p);
	}
}