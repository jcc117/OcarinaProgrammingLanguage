package ast;

public class Identifier extends Expression{
	public String i;
	public Type t;

	public Identifier(String i, Type t){
		this.i = i;
		this.t = t;
	}
}