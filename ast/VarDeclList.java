package ast;

import java.util.ArrayList;

public class VarDeclList{
	public ArrayList<VarDecl> l;

	public VarDeclList(){
		this.l = new ArrayList<VarDecl>();
	}

	public void add(VarDecl v){
		l.add(v);
	}
}