package ast;

public class Param {
	public Type t;
	public Identifier i;

	public Param(Type t, Identifier i){
		this.t = t;
		this.i = i;
	}
}