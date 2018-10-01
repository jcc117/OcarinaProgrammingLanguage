package ast;
import symboltable.*;

public class For extends Statement{
	public Expression e;
	public Statement s1;
	public Statement s2;
	public StatementList s3;

	public For(Expression e, Statement s1, Statement s2, StatementList s3, int line, int column){
		this.e = e;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		breakPoint = false;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	/*
	public Sym accept(Visitor v){
		return v.visit(this);
	}*/
}