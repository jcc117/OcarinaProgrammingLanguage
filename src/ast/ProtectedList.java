package ast;
import symboltable.*;

public class ProtectedList extends Definition{
	public DefList defList;

	public ProtectedList(DefList d){
		defList = d;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public void accept(Visitor v){
		v.visit(this);
	}
}