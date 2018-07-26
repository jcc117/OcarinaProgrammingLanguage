package ast;
import symboltable.*;
import java.util.ArrayList;

public class IdChain{
	public ArrayList<Identifier> chain;
	public IdChain(){
		chain = new ArrayList<Identifier>();
	}

	public void add(Identifier i){
		chain.add(i);
	}

	public void add(Identifier i, int x){
		chain.add(x, i);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}