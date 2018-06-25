package ast;

public class ArrayCreate extends Expression{
	Type t;
	Expression e;

	public ArrayCreate(Type t, Expression e){
		this.t = t;
		this.e = e;
	}
}