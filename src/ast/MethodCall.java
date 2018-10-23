package ast;
import symboltable.*;

public class MethodCall extends Expression{
	public Expression e;
	public ParamList l;

	public MethodCall(Expression e, ParamList l, int line, int column){
		this.e = e;
		this.l = l;
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