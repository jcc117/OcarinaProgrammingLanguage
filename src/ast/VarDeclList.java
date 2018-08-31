package ast;
import symboltable.*;

import java.util.ArrayList;

public class VarDeclList{
	public ArrayList<Statement> l;

	public VarDeclList(){
		this.l = new ArrayList<Statement>();
	}

	public void add(Statement v){
		l.add(v);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}