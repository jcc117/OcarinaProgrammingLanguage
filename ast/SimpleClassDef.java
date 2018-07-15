package ast;

public class SimpleClassDef implements ClassDef{
	public Identifier i;
	public DefList d;
	public VarDeclList v;
	public int protection;

	public SimpleClassDef(Identifier i, DefList d, VarDeclList v, int protection){
		this.i = i;
		this.d = d;
		this.v = v;
		this.protection = protection;
	}
}