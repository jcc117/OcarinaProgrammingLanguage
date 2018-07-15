package ast;

import java.util.*;

public class ConstructorList{
	public ArrayList<Constructor> l;

	public ConstructorList(){
		this.l = new ArrayList<Constructor>(); 
	}

	public void add(Constructor s){
		l.add(s);
	}
}