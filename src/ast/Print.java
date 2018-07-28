package ast;
import symboltable.*;

public class Print extends Statement{
	public Expression e;

	public Print(Expression e){
		this.e = e;
		breakPoint = false;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}