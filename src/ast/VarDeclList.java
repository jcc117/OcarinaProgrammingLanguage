package ast;
import symboltable.*;

import java.util.ArrayList;

public class VarDeclList{
	public ArrayList<VarDecl> l;

	public VarDeclList(){
		this.l = new ArrayList<VarDecl>();
	}

	public void add(VarDecl v){
		l.add(v);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}