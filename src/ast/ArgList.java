package ast;
import symboltable.*;

import java.util.ArrayList;

public class ArgList{
	public Param p;
	public ArgChain chain;

	public ArgList(Param p, ArgChain chain){
		this.p = p;
		this.chain = chain;
	}

	public ArgList(){
		this.p = null;
		this.chain = null;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}