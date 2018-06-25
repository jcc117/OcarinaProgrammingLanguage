package ast;

import java.math.BigDecimal;

public class FloatLiteral extends Expression{
	public BigDecimal f;

	public FloatLiteral(BigDecimal f){
		this.f = f;
	}
}