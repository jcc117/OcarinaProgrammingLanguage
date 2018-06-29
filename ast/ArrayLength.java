package ast;

public class ArrayLength extends Expression{
	public Expression e;
	
	public ArrayLength(Expression e){
		this.e = e;
	}
}