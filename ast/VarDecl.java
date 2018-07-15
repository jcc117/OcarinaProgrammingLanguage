package ast;

public class VarDecl implements Statement{
	public Type t;
	public Identifier i;
	public boolean breakPoint;
	public int protection;

	public VarDecl(Type t, Identifier i, int protection){
		this.t = t;
		this.i = i;
		breakPoint = false;
		this.protection = protection;
	}
}