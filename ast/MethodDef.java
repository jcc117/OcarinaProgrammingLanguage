package ast;

public class MethodDef implements Def{
	public Type r;
	public Identifier i;
	public ArgList a;
	public StatementList s;

	public MethodDef(Type r, Identifier i, ArgList a, StatementList s){
		this.r = r;
		this.i = i;
		this.a = a;
		this.s = s;
	}
}