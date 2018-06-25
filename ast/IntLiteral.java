package ast;

import java.math.BigInteger;

public class IntLiteral extends Expression{
	public BigInteger i;

	public IntLiteral(BigInteger i){
		this.i = i;
	}
}