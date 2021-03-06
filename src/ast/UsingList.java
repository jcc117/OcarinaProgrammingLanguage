package ast;
import java.util.ArrayList;
import symboltable.*;

public class UsingList{
	public ArrayList<Using> l;

	public UsingList(){
		l = new ArrayList<Using>();
	}

	public void add(Using u){
		l.add(u);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}