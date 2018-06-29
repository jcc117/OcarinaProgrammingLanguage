package ast;

import java.util.*;

public class DefList {
	public ArrayList<Def> l;

	public DefList(){
		l = new ArrayList<Def>();
	}

	public void add(Def d){
		l.add(d);
	}
}