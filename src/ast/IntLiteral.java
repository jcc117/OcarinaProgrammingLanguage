package ast;
import symboltable.*;

import java.math.BigInteger;

public class IntLiteral extends Expression{
	public BigInteger i;

	public IntLiteral(BigInteger i, int line, int column){
		this.i = i;
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