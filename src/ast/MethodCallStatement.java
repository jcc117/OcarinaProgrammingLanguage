package ast;
import symboltable.*;

public class MethodCallStatement extends Statement{
	public MethodCall method;

	public MethodCallStatement(MethodCall m){
		this.method = m;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}