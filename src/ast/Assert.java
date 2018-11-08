package ast;
import symboltable.*;

public class Assert extends Statement{
	public Expression e;
	public Expression print_expression;

	public Assert(Expression e, int line, int column){
		this.e = e;
		breakPoint = false;
		this.line = line;
		this.column = column;
		this.print_expression = null;
	}

	public Assert(Expression e, Expression print_expression, int line, int column){
		this.e = e;
		breakPoint = false;
		this.line = line;
		this.column = column;
		this.print_expression = print_expression;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
}