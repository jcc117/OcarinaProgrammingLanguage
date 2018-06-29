package ast;

public class StringLiteral extends Expression{
	public String s;

	public StringLiteral(String s){
		this.s = s;
	}
}