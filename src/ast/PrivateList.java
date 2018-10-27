package ast;
import symboltable.*;

public class PrivateList extends Definition{
	public DefList defList;

	public PrivateList(DefList d){
		defList = d;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public void accept(Visitor v){
		v.visit(this);
	}
}