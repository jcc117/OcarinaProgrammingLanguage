package ast;
import symboltable.*;

public class MethodCallStatement extends Statement{
	public MethodCall method;

	public MethodCallStatement(MethodCall m, int line, int column){
		this.method = m;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}