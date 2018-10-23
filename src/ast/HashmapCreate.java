package ast;
import symboltable.*;

public class HashmapCreate extends Expression{
	public Type t1;
	public Type t2;

	public HashmapCreate(Type t1, Type t2, int line, int column){
		this.t1 = t1;
		this.t2 = t2;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public TypeSym accept(Visitor v){
		return v.visit(this);
	}
}