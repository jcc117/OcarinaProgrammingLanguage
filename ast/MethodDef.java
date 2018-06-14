package ast;

public class MethodDef implements Def{
	public RetType r;
	public Identifier i;
	public ArgList a;
	public StatementList s;

	public MethodDef(RetType r, Identifier i, ArgList a, StatementList s){
		this.r = r;
		this.i = i;
		this.a = a;
		this.s = s;
	}
}