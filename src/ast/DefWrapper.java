package ast;
import symboltable.*;

public class DefWrapper extends Definition{
	public Def item;

	public DefWrapper(Def item){
		this.item = item;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public void accept(Visitor v){
		v.visit(this);
	}
}