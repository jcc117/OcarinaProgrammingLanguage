package ast;

import java.util.*;

public class RatherList{
	public ArrayList<Rather> l;

	public RatherList(){
		this.l = new ArrayList<Rather>(); 
	}

	public void add(Rather r){
		l.add(r);
	}
}