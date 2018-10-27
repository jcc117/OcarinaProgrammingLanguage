package ast;
import java.util.ArrayList;
import symboltable.*;

public class DefinitionList{
	public ArrayList<Definition> defs;

	public DefinitionList(){
		defs = new ArrayList<Definition>();
	}

	public void add(Definition d){
		defs.add(d);
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public void accept(Visitor v){
		v.visit(this);
	}
}