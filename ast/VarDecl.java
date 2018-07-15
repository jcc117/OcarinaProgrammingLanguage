package ast;

public class VarDecl extends Statement{
	public Type t;
	public Identifier i;
	public int protection;

	public VarDecl(Type t, Identifier i, int protection){
		this.t = t;
		this.i = i;
		breakPoint = false;
		this.protection = protection;
	}
}