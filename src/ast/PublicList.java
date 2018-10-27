package ast;
import symboltable.*;

public class PublicList extends Definition{
	public DefList defList;

	public PublicList(DefList d){
		defList = d;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public void accept(Visitor v){
		v.visit(this);
	}
}