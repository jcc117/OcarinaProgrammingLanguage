package ast;
import symboltable.*;

import java.math.BigDecimal;

public class FloatLiteral extends Expression{
	public BigDecimal f;

	public FloatLiteral(BigDecimal f, int line, int column){
		this.f = f;
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